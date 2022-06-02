package com.aiss.f1api.controllers;


import java.util.List;
import java.util.Optional;

import com.aiss.f1api.models.ConstructorModel;

import com.aiss.f1api.services.ConstructorService;

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
@RequestMapping("/constructor")
public class ConstructorController {
    @Autowired
    ConstructorService constructorService;

    @ApiOperation(value = "Obtiene un contructor dado un id")
    @GetMapping("{id}")
    public Optional<ConstructorModel> getById(@PathVariable("id") Long id){
        return this.constructorService.getById(id);
    }
    @ApiOperation(value = "Obtiene el ranking de contructores en un año concreto")
    @GetMapping("/query")
    public List<ConstructorModel> getByYear(@RequestParam("year") Integer year){
        return constructorService.getByYear(year);
    }
    @ApiOperation(value = "Obtiene todos los constructores de forma paginada")
    @GetMapping()
    public List<ConstructorModel> listConstructors
    (@RequestParam(value="page", defaultValue = "0", required = false) int pages,
    @RequestParam(value = "pageSize", defaultValue = "20", required = false) int size,
    @RequestParam(value = "sortBy", defaultValue = "id", required = false) String ordenarPor,
    @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir){
        return constructorService.getAllConstructors(pages, size, ordenarPor, sortDir);
    }   

    @ApiOperation(value = "Crea un nuevo constructor")
    @PostMapping()
    public ConstructorModel saveConstructor(@RequestBody ConstructorModel constructor){
        return this.constructorService.saveConstructor(constructor);
    }
    @ApiOperation(value = "Elimina un constructor")
    @DeleteMapping("{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.constructorService.deleteConstructor(id);
        if (ok){
            return "Se elmino el constrructor con id "+id;
        }else{
            return "No se pudo eliminar el constructor con Id"+id;
        }
    }
    @ApiOperation(value = "Modificar un construtor")
    @PutMapping("{id}")
    public ConstructorModel updateConstructor(@PathVariable("id") Long id, @RequestBody ConstructorModel constructor){
        ConstructorModel constructor1 = constructorService.getById(id).get();
        constructor1.setPos(constructor.getPos());
        constructor1.setTeam(constructor.getTeam());
        constructor1.setYear(constructor.getYear());
        return constructorService.saveConstructor(constructor1);
    }
}