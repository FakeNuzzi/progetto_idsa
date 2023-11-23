package idsa.progetto_idsa.mapper;

import idsa.progetto_idsa.entity.Paziente;
import idsa.progetto_idsa.dto.PazienteDto;

public class PazienteMapper{
    public static PazienteDto mapToPazienteDto(Paziente paziente){
        return new PazienteDto(
            paziente.getId_paziente(),
            paziente.getUser_id()
        );
    }
    
    public static Paziente mapToPaziente(PazienteDto pazienteDto){
        return new Paziente(
            pazienteDto.getId_paziente(),
            pazienteDto.getUser_id()
            //pazienteDto.getTickets()
        );
    }    
}