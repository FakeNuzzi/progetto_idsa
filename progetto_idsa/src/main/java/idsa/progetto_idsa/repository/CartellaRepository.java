package idsa.progetto_idsa.repository;

import idsa.progetto_idsa.entity.Cartella;
import idsa.progetto_idsa.entityID.CartellaID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartellaRepository extends JpaRepository <Cartella, CartellaID> {
}
