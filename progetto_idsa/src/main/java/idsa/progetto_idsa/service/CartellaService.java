package idsa.progetto_idsa.service;

import idsa.progetto_idsa.dto.CartellaDto;
import idsa.progetto_idsa.entityID.CartellaID;

public interface CartellaService{
    CartellaDto createCartella(CartellaDto cartellaDto);
    CartellaDto getCartellaById(CartellaID id_cartella);
}
