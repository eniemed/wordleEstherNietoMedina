package com.example.wordle_esthernietomedina.controller;

import com.example.wordle_esthernietomedina.modelo.Jugador;
import com.example.wordle_esthernietomedina.repo.JugadorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JugadorController {

    private final JugadorRepo jugadorRepo;

    @GetMapping("/jugadores")
    public ResponseEntity<?> getAllPlayers() {
        List<Jugador> allPlayers = jugadorRepo.findAll();

        if (allPlayers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(allPlayers);
    }


    @GetMapping("/jugadores/{id}")
    public ResponseEntity<?> getPlayer(@PathVariable Long id) {
        Jugador player = jugadorRepo.findById(id).orElse(null);

        return (player == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(player);
    }


    @PostMapping("/jugadores")
    public ResponseEntity<?> addPlayer(@RequestBody Jugador newPlayer) {

        newPlayer.setScore(0);
        Jugador newPlayerCreated = jugadorRepo.save(newPlayer);
        return new ResponseEntity<>(newPlayerCreated, HttpStatus.CREATED);
    }


    @DeleteMapping("/jugadores/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable Long id) {
        Jugador deletedPlayer = jugadorRepo.findById(id).orElse(null);

        if (deletedPlayer == null) {
            return ResponseEntity.notFound().build();
        }

        jugadorRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(deletedPlayer);
    }

    @PutMapping("jugadores/{id}")
    public ResponseEntity<?> updatePlayer(@RequestBody Jugador updatedPlayer, @PathVariable Long id) {
        Jugador jugador = jugadorRepo.findById(id).orElse(null);

        if (jugador == null) {
            return ResponseEntity.notFound().build();
        }

        updatedPlayer.setId(id);
        Jugador updatedPlayerData = jugadorRepo.save(updatedPlayer);
        return new ResponseEntity<>(updatedPlayerData, HttpStatus.OK);

    }
}