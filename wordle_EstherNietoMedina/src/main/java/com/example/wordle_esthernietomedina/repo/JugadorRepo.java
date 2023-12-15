package com.example.wordle_esthernietomedina.repo;

import com.example.wordle_esthernietomedina.modelo.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepo extends JpaRepository<Jugador, Long> {
}
