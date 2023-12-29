package idsa.progetto_idsa.mapper;

import idsa.progetto_idsa.dto.MedicoDto;
import idsa.progetto_idsa.entity.Medico;

public class MedicoMapper {
    public static MedicoDto mapToMedicoDto(Medico medico) {
        return new MedicoDto(
            medico.getId_utente(),
            medico.getNome(),
            medico.getCognome(),
            medico.getData_n(),
            medico.getCf(),
            medico.getEmail(),
            medico.getPassword(),
            medico.getStipendio(),
            medico.getSpecializ(),
            medico.getIdAppuntamenti(),
            medico.getTipiVisite()
        );
    }

    public static Medico mapToMedico(MedicoDto medicoDto) {
        return new Medico(
            medicoDto.getId_utente(),
            medicoDto.getNome(),
            medicoDto.getCognome(),
            medicoDto.getData_n(),
            medicoDto.getCf(),
            medicoDto.getEmail(),
            medicoDto.getPassword(),
            medicoDto.getStipendio(),
            medicoDto.getSpecializ(),
            medicoDto.getAppuntamenti(),
            medicoDto.getVisite()
        );
    }
}
