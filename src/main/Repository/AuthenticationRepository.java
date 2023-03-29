package main.Repository;

import main.Model.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {
    Optional<Authentication> findByUuid_Uuid(String uuid);
}