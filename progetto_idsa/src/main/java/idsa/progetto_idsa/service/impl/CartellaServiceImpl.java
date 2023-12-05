package idsa.progetto_idsa.service.impl;

import idsa.progetto_idsa.dto.CartellaDto;
import idsa.progetto_idsa.dto.PazienteDto;
import idsa.progetto_idsa.entity.Cartella;
import idsa.progetto_idsa.entityID.CartellaID;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.mapper.CartellaMapper;
import idsa.progetto_idsa.repository.CartellaRepository;
import idsa.progetto_idsa.service.CartellaService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CartellaServiceImpl implements CartellaService {
    private CartellaRepository cartellaRepository;
    
    @Override
    public CartellaDto createCartella(CartellaDto cartellaDto) {
        Cartella cartella = CartellaMapper.mapToCartella(cartellaDto);
        Cartella savedCartella= cartellaRepository.save(cartella);
        return CartellaMapper.mapToCartellaDto(savedCartella);
    }

    @Override
    public CartellaDto getCartellaById(CartellaID id_cartella){
        Cartella cartella = cartellaRepository.findById(id_cartella)
            .orElseThrow(() -> new ResourceNotFoundException("Cartella non esiste per un dato id : " + id_cartella));
            return CartellaMapper.mapToCartellaDto(cartella);
    }

    @Override
    public List<CartellaDto> getAllCartelle(){
        List<Cartella> cartelle = cartellaRepository.findAll();
        return cartelle.stream().map((cartella) -> CartellaMapper.mapToCartellaDto(cartella))
            .collect(Collectors.toList());
    }

    @Override
    public CartellaDto updateCartella(CartellaID id_cartella, CartellaDto updatedCartella){
        Cartella cartella = cartellaRepository.findById(id_cartella)
            .orElseThrow(() -> new ResourceNotFoundException("Cartella non esiste per l'id dato : " + id_cartella));
        cartella.setPaziente(updatedCartella.getPaziente());
        cartella.setReferti(updatedCartella.getReferti());

        Cartella updatedCartellaObj = cartellaRepository.save(cartella);

        return CartellaMapper.mapToCartellaDto(updatedCartellaObj);
    }

    @Override
    public void deleteCartella(CartellaID id_cartella){
        cartellaRepository.findById(id_cartella)
            .orElseThrow(() -> new ResourceNotFoundException("Appuntamento non esiste per l'id dato : " + id_cartella));
        cartellaRepository.deleteById(id_cartella);
    }

    public List<CartellaDto> findByPaziente(PazienteDto pazienteDto){
        List<Cartella> cartelle = cartellaRepository.findByPaziente(pazienteDto);
        return cartelle.stream().map((cartella) -> CartellaMapper.mapToCartellaDto(cartella))
                .collect(Collectors.toList());
    }
}
