package idsa.progetto_idsa.repository;

import idsa.progetto_idsa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<org.apache.catalina.User> findByEmail(String email);
}
