package com.example.wordle_esthernietomedina.controller;


import com.example.wordle_esthernietomedina.modelo.Equipo;
import com.example.wordle_esthernietomedina.repo.EquipoRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Getter
@Setter
public class EquipoController {

    private final EquipoRepo equipoRepo;

    public EquipoController(EquipoRepo equipoRepo) {this.equipoRepo = equipoRepo;}

    @GetMapping("/equipos")
    public ResponseEntity<?> getAllTeams(){
        List<Equipo> allTeams = equipoRepo.findAll();

        if(allTeams.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(allTeams);
    }

    @GetMapping("/equipos/{id}")
    public ResponseEntity<?> getTeam(@PathVariable Long id){
        Equipo team = equipoRepo.findById(id).orElse(null);

        return (team == null) ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(team);
    }


    @DeleteMapping("/equipos/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long id){
        Equipo deletedTeam = equipoRepo.findById(id).orElse(null);

        if(deletedTeam == null){
            return ResponseEntity.notFound().build();
        }

        equipoRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(deletedTeam);
    }

    @PutMapping("equipos/{id}")
    public ResponseEntity<?> updateTeam(@RequestBody Equipo teamNewData, @PathVariable Long id){
        Equipo team = equipoRepo.findById(id).orElse(null);

        if(team == null){
            return ResponseEntity.notFound().build();
        }

        if (teamNewData.getNombre() != null)
            team.setNombre(teamNewData.getNombre());

        if (teamNewData.getBadge() != null)
            team.setBadge(teamNewData.getBadge());

        equipoRepo.save(team);

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(team);
    }

}