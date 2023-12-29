package idsa.progetto_idsa.mapper;

import idsa.progetto_idsa.dto.PazienteDto;
import idsa.progetto_idsa.entity.Paziente;

public class PazienteMapper {
    public static PazienteDto mapToPazienteDto(Paziente paziente) {
        return new PazienteDto(
            paziente.getId_utente(),
            paziente.getNome(),
            paziente.getCognome(),
            paziente.getData_n(),
            paziente.getCf(),
            paziente.getEmail(),
            paziente.getPassword(),
            paziente.getIdAppuntamenti()
        );
    }

    public static Paziente mapToPaziente(PazienteDto pazienteDto) {
        return new Paziente(
            pazienteDto.getId_utente(),
            pazienteDto.getNome(),
            pazienteDto.getCognome(),
            pazienteDto.getData_n(),
            pazienteDto.getCf(),
            pazienteDto.getEmail(),
            pazienteDto.getPassword(),
            pazienteDto.getAppuntamenti()
        );
    }
}