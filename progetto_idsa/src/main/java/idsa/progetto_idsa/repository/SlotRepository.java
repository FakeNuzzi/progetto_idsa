package idsa.progetto_idsa.repository;

import idsa.progetto_idsa.entity.Slot;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<Slot,Long> {
    List<Slot> findByOccupato(Boolean occupato);
}
