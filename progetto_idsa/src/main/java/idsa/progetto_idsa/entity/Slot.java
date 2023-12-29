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
    private Date dataOraSlot;
    @Column(name = "Occupata", nullable = false)
    private Boolean occupato;

    @OneToOne(mappedBy = "slot")
    private Appuntamento appuntamento;
}
