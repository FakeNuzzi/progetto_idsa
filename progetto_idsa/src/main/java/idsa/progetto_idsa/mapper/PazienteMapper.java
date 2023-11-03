package idsa.progetto_idsa.mapper;

import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.dto.PazienteDto;

public class PazienteMapper{
    public static PazienteDto mapToPazienteDto(Paziente paziente){
        return new PazienteDto(
            paziente.getId_paziente(),
            paziente.getNome(),
            paziente.getCognome(),
            paziente.getData_n(),
            paziente.getCf()
        );
    }    
}