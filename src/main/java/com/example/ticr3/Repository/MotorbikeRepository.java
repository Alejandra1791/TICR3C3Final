package com.example.ticr3.Repository;


import com.example.ticr3.Entities.Motorbike;
import com.example.ticr3.Repository.crudRepository.MotorbikeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MotorbikeRepository {

    @Autowired
    private MotorbikeCrudRepository motorbikeCrudRepository;

    public List<Motorbike> getAll(){
        return (List<Motorbike>) motorbikeCrudRepository.findAll();
    }

    public Optional<Motorbike> getMotorbike(int id){
        return motorbikeCrudRepository.findById(id);
    }

    public Motorbike save(Motorbike motorbike){
        return motorbikeCrudRepository.save(motorbike);
    }

    public void delete(Motorbike motorbike){
        motorbikeCrudRepository.delete(motorbike);
    }
}
