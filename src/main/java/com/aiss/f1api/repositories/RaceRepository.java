package com.aiss.f1api.repositories;

import java.util.ArrayList;

import com.aiss.f1api.models.RaceModel;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RaceRepository extends JpaRepository<RaceModel, Long>{

    public abstract ArrayList<RaceModel> findByGp(String gp);
    
}