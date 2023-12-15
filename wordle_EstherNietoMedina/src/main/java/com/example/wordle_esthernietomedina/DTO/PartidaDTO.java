package com.example.wordle_esthernietomedina.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartidaDTO {

    private int jugador_id;
    private int juego_id;
    private String palabra;
    private int intentos;
    private int score;
    private int id;
}
