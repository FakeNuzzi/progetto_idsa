package idsa.progetto_idsa.dto;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import idsa.progetto_idsa.entity.Appuntamento;
import idsa.progetto_idsa.repository.AppuntamentoRepository;
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

    @Autowired
    AppuntamentoRepository appuntamentoRepository;

    public SlotDto(Date dataOraSlot, Boolean occupato, Long id_appuntamento) {
        this.dataOraSlot = dataOraSlot;
        this.occupato = occupato;
        this.id_appuntamento = id_appuntamento;
    }

    public Appuntamento getAppuntamento() {
        Appuntamento appuntamento = appuntamentoRepository.findById(id_appuntamento).get();
        return appuntamento;
    }
}