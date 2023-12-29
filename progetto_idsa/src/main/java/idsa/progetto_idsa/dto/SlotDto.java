package idsa.progetto_idsa.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SlotDto {
    private Date dataOraSlot;
    private Boolean occupato;
    private Long id_appuntamento;
}