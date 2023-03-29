package main.Security.User;

import main.Model.Authorization;
import main.Repository.AuthenticationRepository;
import main.Repository.AuthorizationRepository;
import main.Security.User.User;
import main.Security.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UsernamePwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationRepository authenticationRepository;
    @Autowired
    private AuthorizationRepository authorizationRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        Optional<User> optionalUser = this.userRepository.findByEmail(username);

        if (!optionalUser.isEmpty()) {
            Optional<main.Model.Authentication> optionalAuthentication = this.authenticationRepository.findByUuid_Uuid(optionalUser.get().getUuid());
            if (passwordEncoder.matches(password, optionalAuthentication.get().getPassword())) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                Optional<Authorization> optionalAuthorization = this.authorizationRepository.findByUuid_Uuid(optionalUser.get().getUuid());
                optionalAuthorization.get().getRoles().forEach( role -> {
                    authorities.add(new SimpleGrantedAuthority(role.getRole()));
                });
                return new UsernamePasswordAuthenticationToken(username, password, authorities);
            } else {
                throw new BadCredentialsException("Invalid password!");
            }

        } else {
            throw new BadCredentialsException("No user registered with this details!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
