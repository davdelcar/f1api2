package com.aiss.f1api.controllers;

import com.aiss.f1api.services.DriverService;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import com.aiss.f1api.models.DriverModel;


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
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    DriverService driverService;
    
    @ApiOperation(value = "Obtiene un piloto dado un id")
    @GetMapping("{id}")
    public Optional<DriverModel> getById(@PathVariable("id") Long id){
        return driverService.getById(id);
    }
    @ApiOperation(value = "Obtiene un piloto en un año concreto")
    @GetMapping("/query")
    public ArrayList<DriverModel> getByYear(@RequestParam("year") Integer year){
        return driverService.getByYear(year);
    }
    @ApiOperation(value = "Obtiene todos los pilotos de forma paginada")
    @GetMapping()
    public List<DriverModel> listDrivers
    (@RequestParam(value="page", defaultValue = "0", required = false) int pages,
    @RequestParam(value = "pageSize", defaultValue = "20", required = false) int size,
    @RequestParam(value = "sortBy", defaultValue = "id", required = false) String ordenarPor,
    @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir){
        return driverService.getAllDrivers(pages, size, ordenarPor, sortDir);
    } 
    @ApiOperation(value = "Crea un nuevo piloto")
    @PostMapping()
    public DriverModel saveDriver(@RequestBody DriverModel driver){
        return driverService.saveDriver(driver);
    }
    @ApiOperation(value = "Elimina un piloto")
    @DeleteMapping("{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.driverService.deleteDriver(id);
        if (ok){
            return "Se elimino el driver con id "+id;
        }else{
            return "No se pudo eliminar el driver con Id"+id;
        }
    }
    @ApiOperation(value = "Modificar un piloto")
    @PutMapping("{id}")
    public DriverModel updateDriver(@PathVariable("id") Long id, @RequestBody DriverModel driver){
        DriverModel driver1 = driverService.getById(id).get();
        driver1.setPos(driver.getPos());
        driver1.setName(driver.getName());
        driver1.setYear(driver.getYear());
        driver1.setNationality(driver.getNationality());
        driver1.setCar(driver.getCar());
        driver1.setPts(driver.getPts());
        return driverService.saveDriver(driver1);
    }
}