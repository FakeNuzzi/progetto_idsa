package idsa.progetto_idsa.service.impl;

import idsa.progetto_idsa.dto.CartellaDto;
import idsa.progetto_idsa.entity.Cartella;
import idsa.progetto_idsa.mapper.CartellaMapper;
import idsa.progetto_idsa.repository.CartellaRepository;
import idsa.progetto_idsa.service.CartellaService;
import lombok.AllArgsConstructor;
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
}
