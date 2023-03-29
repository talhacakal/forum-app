package main.Service.Concrete;

import main.Model.DTO.ProfileDTO;
import main.Model.DTO.ProfileWithEntries;
import main.Model.Entry;
import main.Model.Profile;
import main.Repository.EntryRepository;
import main.Repository.ProfileRepository;
import main.Service.Abstract.ProfileService;
import main.Security.User.User;
import main.Security.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileManager implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntryRepository entryRepository;

    @Override
    public ResponseEntity getProfile(String email) {
        Optional<Profile> optionalProfile = this.profileRepository.findByUuid_Email(email);
        if (optionalProfile.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        return ResponseEntity.ok(optionalProfile.get());
    }
    @Override
    public ResponseEntity entries(String email) {
        Optional<Profile> optionalProfile = this.profileRepository.findByUuid_Email(email);
        List<Entry> entryList = this.entryRepository.findByUid_Email(email);
        if (optionalProfile.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");

        ProfileWithEntries profileWithEntries = ProfileWithEntries.builder()
                .name(optionalProfile.get().getName())
                .lastName(optionalProfile.get().getLastName())
                .personalInfo(optionalProfile.get().getPersonalInfo())
                .location(optionalProfile.get().getLocation())
                .entries(entryList)
                .build();

        return ResponseEntity.ok(profileWithEntries);
    }
    @Override
    public ResponseEntity createProfile(String email, ProfileDTO userProfile) {
        User user = this.userRepository.findByEmail(email).get();
        if (!this.profileRepository.findByUuid_Email(email).isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already has profile");

        Profile profile = Profile.builder()
                .uuid(user)
                .name(userProfile.getName())
                .lastName(userProfile.getLastName())
                .birth(userProfile.getBirth())
                .personalInfo(userProfile.getPersonalInfo())
                .location(userProfile.getLocation()).build();

        return ResponseEntity.ok(this.profileRepository.save(profile));
    }
    @Override
    public ResponseEntity updateProfile(String email, ProfileDTO userProfile) {
        Optional<Profile> optionalProfile = this.profileRepository.findByUuid_Email(email);

        if (optionalProfile.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Create profile!");

        optionalProfile.get().setName(userProfile.getName());
        optionalProfile.get().setLastName(userProfile.getLastName());
        optionalProfile.get().setBirth(userProfile.getBirth());
        optionalProfile.get().setPersonalInfo(userProfile.getPersonalInfo());
        optionalProfile.get().setLocation(userProfile.getLocation());

        return ResponseEntity.ok(this.profileRepository.save(optionalProfile.get()));
    }
}
