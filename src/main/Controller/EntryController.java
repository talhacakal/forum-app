package main.Controller;

import main.Model.DTO.EntryDTO;
import main.Model.Entry;
import main.Repository.EntryRepository;
import main.Service.Abstract.EntryService;
import main.Security.User.User;
import main.Security.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/entry")
public class EntryController {

    @Autowired
    private EntryRepository entryRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntryService entryService;

    @GetMapping("/{eid}")
    public Object getEntry(@PathVariable String eid) {
        Optional<Entry> optionalEntry = this.entryRepository.findByEid(eid);
        if (optionalEntry.isPresent()) return optionalEntry.get();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @GetMapping("/getUserEntry")
    public List<Entry> getUserEntry(@RequestParam String email) {
        return this.entryRepository.findByUid_Email(email);
    }
    @PostMapping("/auth")
    public Object saveEntry(Authentication authentication, @RequestBody EntryDTO entrydto) {
        Optional<User> optionalUser = this.userRepository.findByEmail(authentication.getName());
        Entry entry = Entry.builder()
                .uid(optionalUser.get())
                .content(entrydto.getContent())
                .openFComment(entrydto.isOpenFComment()).build();
        return ResponseEntity.ok(this.entryRepository.save(entry));
    }
    @PutMapping("/auth")
    public Object updateEntry(@RequestBody EntryDTO entrydto) {
        Optional<Entry> optionalEntry = this.entryRepository.findByEid(entrydto.getEid());
        if (optionalEntry.isEmpty())
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        return this.entryService.updateEntry(entrydto, optionalEntry.get());
    }
    @PutMapping("/auth/closeComment/{eid}")
    public Object closeComment(@PathVariable String eid) {
        Optional<Entry> optionalEntry = this.entryRepository.findByEid(eid);
        if (optionalEntry.isEmpty())
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        return this.entryService.closeComment(optionalEntry.get());
    }
    @PutMapping("/auth/openComment/{eid}")
    public Object openComment(@PathVariable String eid) {
        Optional<Entry> optionalEntry = this.entryRepository.findByEid(eid);
        if (optionalEntry.isEmpty())
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        return this.entryService.openComment(optionalEntry.get());
    }
    @DeleteMapping("/auth/{eid}")
    public Object deleteEntry(@PathVariable String eid) {
        Optional<Entry> optionalEntry = this.entryRepository.findByEid(eid);
        if (optionalEntry.isEmpty())
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        return this.entryService.deleteEntry(optionalEntry.get());
    }
}
