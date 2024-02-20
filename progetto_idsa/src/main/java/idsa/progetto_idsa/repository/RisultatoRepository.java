package idsa.progetto_idsa.repository;

import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.entity.Risultato;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RisultatoRepository extends JpaRepository<Risultato,Long> {
    List<Risultato> findByAppuntamento(Appuntamento paziente);
}
