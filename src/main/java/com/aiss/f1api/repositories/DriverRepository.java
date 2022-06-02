package com.aiss.f1api.repositories;

import com.aiss.f1api.models.DriverModel;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface DriverRepository extends JpaRepository<DriverModel, Long> {
    //Metodos por defecto que trae esta interfaz

    public abstract ArrayList<DriverModel> findByYear(Integer year);
    
}