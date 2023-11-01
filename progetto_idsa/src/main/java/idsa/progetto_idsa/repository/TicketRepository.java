package idsa.progetto_idsa.repository;

import idsa.progetto_idsa.entity.Ticket;
import idsa.progetto_idsa.entityID.TicketID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,TicketID> {
}
