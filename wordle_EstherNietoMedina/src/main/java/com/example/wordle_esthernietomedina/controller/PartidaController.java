package com.example.wordle_esthernietomedina.controller;

import com.example.wordle_esthernietomedina.modelo.Jugador;
import com.example.wordle_esthernietomedina.modelo.Partida;
import com.example.wordle_esthernietomedina.repo.JugadorRepo;
import com.example.wordle_esthernietomedina.repo.PartidaRepo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Getter
@Setter
public class PartidaController {

    private final PartidaRepo partidaRepo;
    private final JugadorRepo jugadorRepo;

    @GetMapping("/partidas")
    public ResponseEntity<?> getAllMatches(){

        List<Partida> allMatches = partidaRepo.findAll();

        if(allMatches.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(allMatches);
    }

    @GetMapping("/partidas/{id}")
    public ResponseEntity<?> getMatch(@PathVariable Long id){
        Partida match = partidaRepo.findById(id).orElse(null);

        return (match == null) ?
                ResponseEntity.notFound().build():ResponseEntity.ok(match);
    }

    @DeleteMapping("/partidas/{id}")
    public ResponseEntity<?> deleteMatch(@PathVariable Long id){
        Partida deletedMatch = partidaRepo.findById(id).orElse(null);

        if(deletedMatch == null){
            return ResponseEntity.notFound().build();
        }

        partidaRepo.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(deletedMatch);
    }
}
