package idsa.progetto_idsa.repository;

import idsa.progetto_idsa.dto.AppuntamentoDto;
import idsa.progetto_idsa.dto.PazienteDto;
import idsa.progetto_idsa.entity.Ticket;
import idsa.progetto_idsa.entityID.TicketID;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,TicketID> {
    List<Ticket> findByAppuntamento(AppuntamentoDto appuntamentoDto);

    List<Ticket> findByPaziente(PazienteDto pazienteDto);
}
