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
    private Long id_slot;
    private Date DataOraSlot;
    private Boolean occupato;
}