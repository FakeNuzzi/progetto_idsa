package idsa.progetto_idsa.dto;

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

public class RisultatoDto {
    private Long id_ris;
    private String referto;
    private String prescr;
    private Long id_appuntamento;

    @Autowired
    AppuntamentoRepository appuntamentoRepository;

    public RisultatoDto(Long id_ris, String referto, String prescr, Long id_appuntamento) {
        this.id_ris = id_ris;
        this.referto = referto;
        this.prescr = prescr;
        this.id_appuntamento = id_appuntamento;
    }

    public Appuntamento getAppuntamento() {
        Appuntamento appuntamento = appuntamentoRepository.findById(id_appuntamento).get();
        return appuntamento;
    }
}
