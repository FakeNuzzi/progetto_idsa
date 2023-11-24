package idsa.progetto_idsa.service;

import java.util.List;

import idsa.progetto_idsa.dto.MedicoDto;
import idsa.progetto_idsa.entityID.MedicoID;

public interface MedicoService {
    MedicoDto createMedico(MedicoDto medicoDto);
    MedicoDto getMedicoById(MedicoID id_medico);
    List<MedicoDto> getAllMedici();
    MedicoDto updateMedico(MedicoID id_medico, MedicoDto updatedMedico);
    void deleteMedico(MedicoID id_medico);
}
