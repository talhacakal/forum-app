package main.Controller;

import main.Service.Abstract.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dev/authorization")
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    @GetMapping("")
    public ResponseEntity getAuthorization(@RequestParam String email){
        return this.authorizationService.getAuthorization(email);
    }
    @PostMapping("")
    public ResponseEntity addRole(@RequestParam String email, @RequestParam String roleName){
        return this.authorizationService.addRole(email, roleName);
    }
    @DeleteMapping("")
    public ResponseEntity deleteRoleUser(@RequestParam String email, @RequestParam String roleName){
        return this.authorizationService.deleteRoleUser(email, roleName);
    }
}

