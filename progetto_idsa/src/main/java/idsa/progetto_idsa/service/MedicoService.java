package idsa.progetto_idsa.service;

import java.util.List;

import idsa.progetto_idsa.dto.MedicoDto;

public interface MedicoService {
    MedicoDto createMedico(MedicoDto medicoDto);
    MedicoDto getMedicoById(Long id_utente);
    List<MedicoDto> getAllMedici();
    MedicoDto updateMedico(Long id_utente, MedicoDto updatedMedico);
    void deleteMedico(Long id_utente);
    MedicoDto getMedicoByEmail(String email);
}