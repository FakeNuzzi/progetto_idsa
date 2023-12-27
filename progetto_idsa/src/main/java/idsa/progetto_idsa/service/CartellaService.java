package idsa.progetto_idsa.service;

import java.util.List;

import idsa.progetto_idsa.dto.CartellaDto;
import idsa.progetto_idsa.entityID.CartellaID;

public interface CartellaService{
    CartellaDto createCartella(CartellaDto cartellaDto);
    CartellaDto getCartellaById(CartellaID id_cartella);
    List<CartellaDto> getAllCartelle();
    CartellaDto updateCartella(CartellaID id_cartella, CartellaDto updatedCartella);
    void deleteCartella(CartellaID id_cartella);

    //List<CartellaDto> findByPaziente(PazienteDto pazienteDto);
}
