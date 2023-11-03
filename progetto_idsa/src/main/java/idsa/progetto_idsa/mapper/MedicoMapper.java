package idsa.progetto_idsa.mapper;

import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.dto.MedicoDto;

public class MedicoMapper{
    public static MedicoDto mapToMedicoDto(Medico medico){
        return new MedicoDto(
            medico.getId_medico(),
            medico.getNome(),
            medico.getCognome(),
            medico.getData_n(),
            medico.getCf(),
            medico.getStipendio(),
            medico.getSpecializ()
        );
    }    
}