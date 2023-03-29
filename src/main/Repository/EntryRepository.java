package main.Repository;

import main.Model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

public interface EntryRepository extends JpaRepository<Entry, Long> {
    Optional<Entry> findByEid(String eid);
    List<Entry> findByUid_Email(String email);
}