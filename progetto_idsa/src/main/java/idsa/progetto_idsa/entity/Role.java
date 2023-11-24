package idsa.progetto_idsa.entity;

import idsa.progetto_idsa.entityID.RefertoID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(RefertoID.class)
@Entity
@Table(name = "Ruolo")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ruolo;
    private String name;
}
