package idsa.progetto_idsa.repository;

import idsa.progetto_idsa.entity.ERole;
import idsa.progetto_idsa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
