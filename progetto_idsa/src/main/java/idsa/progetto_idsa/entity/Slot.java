package idsa.progetto_idsa.entity;

import java.sql.Date;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Slot")
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_slot;
    @Column(name = "DataOraSlot", nullable = false, unique = true)
    private Date DataOraSlot;
    @Column(name = "Occupata", nullable = false)
    private Boolean occupato;
}
