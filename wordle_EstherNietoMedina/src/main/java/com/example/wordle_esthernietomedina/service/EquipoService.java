package com.example.wordle_esthernietomedina.service;

import com.example.wordle_esthernietomedina.modelo.Equipo;

import java.util.List;
import java.util.Optional;

public interface EquipoService {
    List<Equipo> findAll();
    Optional<Equipo> findById(Long id);
    Equipo save(Equipo equipo);
    void deleteById(Long id);
    boolean existsById(Long id);
}
