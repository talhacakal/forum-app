package main.Security.Controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import main.Model.Authentication;
import main.Model.Authorization;
import main.Repository.AuthenticationRepository;
import main.Repository.AuthorizationRepository;
import main.Repository.RoleRepository;
import main.Security.Constants.SecurityConstants;
import main.Security.User.User;
import main.Security.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@RestController
@RequiredArgsConstructor
@Transactional
public class AuthController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationRepository authenticationRepository;
    private final AuthorizationRepository authorizationRepository;
    private final RoleRepository roleRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public ResponseEntity authenticateUser(@RequestParam String username, @RequestParam String password) {
        org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
        String jwt = Jwts.builder()
                .claim("username", authentication.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + 10 * 60 * 10000))
                .signWith(key).compact();

        ResponseCookie jwtCookie = ResponseCookie.from("access_token", jwt).path("/api").maxAge(10 * 60 * 10000).build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString()).build();
    }
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestParam String username, @RequestParam String password) {
        if (!this.userRepository.findByEmail(username).isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Already exists.");
        }
        User user = new User();
        Authentication authentication = new Authentication();
        Authorization authorization = new Authorization();

        String hashPassword = passwordEncoder.encode(password);
        authentication.setPassword(hashPassword);
        user.setEmail(username);
        authorization.getRoles().add(this.roleRepository.findByRole("ROLE_USER").get());

        User createdUser = this.userRepository.save(user);
        authentication.setUuid(createdUser);
        authorization.setUuid(createdUser);
        this.authenticationRepository.save(authentication);
        this.authorizationRepository.save(authorization);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
