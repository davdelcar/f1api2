package com.aiss.f1api.repositories;


import java.util.List;


import com.aiss.f1api.models.ConstructorModel;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.stereotype.Repository;

@Repository
public interface ConstructorRepository extends JpaRepository<ConstructorModel, Long>, JpaSpecificationExecutor<ConstructorModel> {
    public abstract List<ConstructorModel> findByYear(Integer year);
    
}