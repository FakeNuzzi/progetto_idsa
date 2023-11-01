package idsa.progetto_idsa.repository;

import idsa.progetto_idsa.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
