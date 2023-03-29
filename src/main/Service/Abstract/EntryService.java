package main.Service.Abstract;

import main.Model.DTO.EntryDTO;
import main.Model.Entry;
import org.springframework.security.access.prepost.PreAuthorize;

public interface EntryService {

    @PreAuthorize("hasAnyRole('ROLE_ADMIN') || authentication.name == #entry.getUid().getEmail()")
    Object updateEntry(EntryDTO entrydto, Entry entry);
    @PreAuthorize("hasAnyRole('ROLE_ADMIN') || authentication.name == #entry.getUid().getEmail()")
    Object closeComment(Entry entry);
    @PreAuthorize("hasAnyRole('ROLE_ADMIN') || authentication.name == #entry.getUid().getEmail()")
    Object openComment(Entry entry);
    @PreAuthorize("hasAnyRole('ROLE_ADMIN') || authentication.name == #entry.getUid().getEmail()")
    Object deleteEntry(Entry entry);
}
