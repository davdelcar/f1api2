package com.aiss.f1api.services;


import java.util.List;
import java.util.Optional;


import com.aiss.f1api.models.ConstructorModel;
import com.aiss.f1api.repositories.ConstructorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ConstructorService {
    @Autowired
    ConstructorRepository constructorRepository;

    public ConstructorModel saveConstructor(ConstructorModel constructor){
        return constructorRepository.save(constructor);
    }
    public Optional<ConstructorModel> getById(Long id){
        return constructorRepository.findById(id);
    }
    public List<ConstructorModel> getByYear(Integer year){
        return constructorRepository.findByYear(year);
    }

    public boolean deleteConstructor(Long id){
        try{
            constructorRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
    public List<ConstructorModel> getAllConstructors(int numeroDePagina, int medidaDePagina, String ordenarPor, String sortDir){
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(ordenarPor).ascending():Sort.by(ordenarPor).descending();
        Pageable pageable =  PageRequest.of(numeroDePagina, medidaDePagina, sort);
        Page<ConstructorModel> constructores = constructorRepository.findAll(pageable);
        List<ConstructorModel> listaDeConstructores = constructores.getContent();
        return listaDeConstructores;
    }
}