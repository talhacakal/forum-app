package main.Controller;

import main.Model.DTO.ProfileDTO;
import main.Service.Abstract.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/{email}")
    public ResponseEntity getProfile(@PathVariable String email) {
        return this.profileService.getProfile(email);
    }
    @GetMapping("/entries/{email}")
    public ResponseEntity entries(@PathVariable String email) {
        return this.profileService.entries(email);
    }
    @PostMapping("/auth")
    public ResponseEntity createProfile(Authentication authentication, @RequestBody ProfileDTO user) {
        return this.profileService.createProfile(authentication.getName(), user);
    }
    @PutMapping("/auth")
    public Object updateProfile(Authentication authentication, @RequestBody ProfileDTO user) {
        return this.profileService.updateProfile(authentication.getName(), user);
    }
}
