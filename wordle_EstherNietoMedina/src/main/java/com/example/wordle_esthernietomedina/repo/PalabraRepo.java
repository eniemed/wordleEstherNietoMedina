package com.example.wordle_esthernietomedina.repo;

import com.example.wordle_esthernietomedina.modelo.Palabra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PalabraRepo extends JpaRepository<Palabra,Long> {
}
