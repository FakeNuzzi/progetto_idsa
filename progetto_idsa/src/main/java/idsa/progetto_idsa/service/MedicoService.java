package idsa.progetto_idsa.service;

import idsa.progetto_idsa.dto.MedicoDto;

public interface MedicoService {
    MedicoDto createMedico(MedicoDto medicoDto);
    MedicoDto getMedicoById(Long id_medico);
}
