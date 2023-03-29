package main.Repository;

import main.Model.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {
    Optional<Authorization> findByUuid_Uuid(String uuid);
    Optional<Authorization> findByUuid_Email(String email);
}