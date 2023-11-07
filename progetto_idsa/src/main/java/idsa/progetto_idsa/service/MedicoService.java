package idsa.progetto_idsa.service;

import java.util.List;

import idsa.progetto_idsa.dto.MedicoDto;

public interface MedicoService {
    MedicoDto createMedico(MedicoDto medicoDto);
    MedicoDto getMedicoById(Long id_medico);
    List<MedicoDto> getAllMedici();
}
