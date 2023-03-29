package main.Service.Concrete;

import jakarta.transaction.Transactional;
import main.Model.Authorization;
import main.Model.Role;
import main.Repository.AuthorizationRepository;
import main.Repository.RoleRepository;
import main.Service.Abstract.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class AuthorizationManager implements AuthorizationService {

    @Autowired
    private AuthorizationRepository authorizationRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public ResponseEntity getAuthorization(String email) {
        Optional<Authorization> optionalAuthorization = this.authorizationRepository.findByUuid_Email(email);
        if (optionalAuthorization.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
        return ResponseEntity.ok(optionalAuthorization);
    }
    @Override
    public ResponseEntity addRole(String email, String roleName) {
        Optional<Authorization> optionalAuthorization = this.authorizationRepository.findByUuid_Email(email);
        Optional<Role> optionalRole = this.roleRepository.findByRole(roleName);
        if (optionalAuthorization.isEmpty() || optionalRole.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        optionalAuthorization.get().getRoles().add(optionalRole.get());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @Override
    public ResponseEntity deleteRoleUser(String email, String roleName) {
        Optional<Authorization> optionalAuthorization = this.authorizationRepository.findByUuid_Email(email);
        Optional<Role> optionalRole = this.roleRepository.findByRole(roleName);
        if (optionalAuthorization.isEmpty() || optionalRole.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        optionalAuthorization.get().getRoles().remove(optionalRole.get());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
