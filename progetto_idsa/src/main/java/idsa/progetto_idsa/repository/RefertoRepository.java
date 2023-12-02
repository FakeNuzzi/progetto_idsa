package idsa.progetto_idsa.repository;

import idsa.progetto_idsa.dto.AppuntamentoDto;
import idsa.progetto_idsa.dto.CartellaDto;
import idsa.progetto_idsa.entity.Referto;
import idsa.progetto_idsa.entityID.RefertoID;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RefertoRepository extends JpaRepository<Referto,RefertoID> {
    List<Referto> findByAppuntamento(AppuntamentoDto appuntamentoDto);

    List<Referto> findByCartella(CartellaDto cartellaDto);
}
