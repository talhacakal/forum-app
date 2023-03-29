package main.Service.Abstract;

import main.Model.DTO.ProfileDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

public interface ProfileService {

    ResponseEntity getProfile(String email);
    ResponseEntity entries(String email);
    ResponseEntity createProfile(String email, ProfileDTO userProfile);
    @PreAuthorize("authentication.name == #email")
    ResponseEntity updateProfile(String email, ProfileDTO userProfile);
}
