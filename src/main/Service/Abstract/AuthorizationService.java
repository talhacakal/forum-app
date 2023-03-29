package main.Service.Abstract;

import org.springframework.http.ResponseEntity;

public interface AuthorizationService {

    ResponseEntity getAuthorization(String email);
    ResponseEntity addRole(String email, String roleName);
    ResponseEntity deleteRoleUser(String email, String roleName);
}
