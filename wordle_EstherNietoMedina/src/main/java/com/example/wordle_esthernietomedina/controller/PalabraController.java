package com.example.wordle_esthernietomedina.controller;

import com.example.wordle_esthernietomedina.modelo.Palabra;
import com.example.wordle_esthernietomedina.repo.PalabraRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PalabraController {

    private final PalabraRepo palabraRepo;

    public PalabraController(PalabraRepo palabraRepo) {this.palabraRepo = palabraRepo;}

    @GetMapping("/palabras")
    public ResponseEntity<?> getAllWords(){
        List<Palabra> allWords = palabraRepo.findAll();

        if(allWords.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(allWords);
    }
}
