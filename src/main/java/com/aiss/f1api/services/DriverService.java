package com.aiss.f1api.services;

import com.aiss.f1api.repositories.DriverRepository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import com.aiss.f1api.models.DriverModel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    @Autowired
    DriverRepository driverRepository;

    public DriverModel saveDriver(DriverModel driver){
        return driverRepository.save(driver);
    }
    public Optional<DriverModel> getById(Long id){
        return driverRepository.findById(id);
    }
    public ArrayList<DriverModel> getByYear(Integer year){
        return driverRepository.findByYear(year);
    }
    public boolean deleteDriver(Long id){
        try{
            driverRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
     }
    public List<DriverModel> getAllDrivers(int numeroDePagina, int medidaDePagina, String ordenarPor, String sortDir){
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(ordenarPor).ascending():Sort.by(ordenarPor).descending();
        Pageable pageable =  PageRequest.of(numeroDePagina, medidaDePagina, sort);
        Page<DriverModel> drivers = driverRepository.findAll(pageable);
        List<DriverModel> listaDeDrivers = drivers.getContent();
        return listaDeDrivers;
    }
}