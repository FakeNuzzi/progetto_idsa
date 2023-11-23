package idsa.progetto_idsa.mapper;

import idsa.progetto_idsa.entity.Medico;
import idsa.progetto_idsa.dto.MedicoDto;

public class MedicoMapper{
    public static MedicoDto mapToMedicoDto(Medico medico){
        return new MedicoDto(
            medico.getId_medico(),
            medico.getStipendio(),
            medico.getSpecializ(),
            medico.getUser_id()
        );
    }

    public static Medico mapToMedico(MedicoDto medicoDto){
        return new Medico(
            medicoDto.getId_medico(),
            medicoDto.getStipendio(),
            medicoDto.getSpecializ(),
            medicoDto.getUser_id()
        );
    }     
}