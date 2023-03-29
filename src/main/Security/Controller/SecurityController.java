package main.Security.Controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import main.Model.Authentication;
import main.Model.Authorization;
import main.Repository.AuthenticationRepository;
import main.Repository.AuthorizationRepository;
import main.Repository.RoleRepository;
import main.Security.User.User;
import main.Security.User.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Transactional
public class SecurityController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationRepository authenticationRepository;
    private final AuthorizationRepository authorizationRepository;
    private final RoleRepository roleRepository;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestParam String username, @RequestParam String password){
        if (!this.userRepository.findByEmail(username).isEmpty()){
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
