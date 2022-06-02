package com.aiss.f1api.controllers;

import com.aiss.f1api.services.RaceService;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import com.aiss.f1api.models.RaceModel;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/race")
public class RaceController {
    @Autowired
    public RaceService raceService;
    

    @ApiOperation(value = "Obtiene una carrera dado un id")
    @GetMapping("{id}")
    public Optional<RaceModel> getById(@PathVariable("id") Long id){
        return raceService.getById(id);
    }
    @ApiOperation(value = "Obtiene una carrera dado un Gran Premio")
    @GetMapping("/query")
    public ArrayList<RaceModel> getByGp(@RequestParam("gp") String gp){
        return raceService.getByGp(gp);
    }
    @ApiOperation(value = "Obtiene todas las carreras de forma paginada")
    @GetMapping()
    public List<RaceModel> listRaces
    (@RequestParam(value="page", defaultValue = "0", required = false) int pages,
    @RequestParam(value = "pageSize", defaultValue = "20", required = false) int size,
    @RequestParam(value = "sortBy", defaultValue = "id", required = false) String ordenarPor,
    @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir){
        return raceService.getAllRaces(pages, size, ordenarPor, sortDir);
    } 
    @ApiOperation(value = "Crea una nueva carrera")
    @PostMapping()
    public RaceModel saveRace(@RequestBody RaceModel race){
        return raceService.saveRace(race);
    }
    @ApiOperation(value = "Elimina una carrera")
    @DeleteMapping("{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.raceService.deleteRace(id);
        if (ok){
            return "Se elimino el race con id "+id;
        }else{
            return "No se pudo eliminar el race con Id"+id;
        }
    }
    @ApiOperation(value = "Modificar una carrera")
    @PutMapping("{id}")
    public RaceModel updateRace(@PathVariable("id") Long id, @RequestBody RaceModel race){
        RaceModel race1 = raceService.getById(id).get();
        race1.setGp(race.getGp());
        race1.setFirst(race.getFirst());
        race1.setSecond(race.getSecond());
        race1.setThird(race.getThird());
        race1.setFourth(race.getFourth());
        race1.setFifth(race.getFifth());
        race1.setSixth(race.getSixth());
        race1.setSeventh(race.getSeventh());
        race1.setEighth(race.getEighth());
        race1.setNineth(race.getNineth());
        race1.setTenth(race.getTenth());
        return raceService.saveRace(race1);
    }
}