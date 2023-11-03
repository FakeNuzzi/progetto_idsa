package idsa.progetto_idsa.mapper;

import idsa.progetto_idsa.entity.Cartella;
import idsa.progetto_idsa.dto.CartellaDto;

public class CartellaMapper{
    public static CartellaDto mapToCartellaDto(Cartella cartella){
        return new CartellaDto(
            cartella.getId_cartella(),
            cartella.getPaziente(),
            cartella.getReferti()
        );
    }

    public static Cartella mapToCartella(CartellaDto cartellaDto){
        return new Cartella(
            cartellaDto.getId_cartella(),
            cartellaDto.getPaziente(),
            cartellaDto.getReferti()
        );
    }     
}