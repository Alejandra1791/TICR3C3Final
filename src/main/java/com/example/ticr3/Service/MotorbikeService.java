package com.example.ticr3.Service;


import com.example.ticr3.Entities.Motorbike;
import com.example.ticr3.Repository.MotorbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorbikeService {
    @Autowired
    private MotorbikeRepository motorbikeRepository;

    public List<Motorbike> getAll(){
        return (List<Motorbike>) motorbikeRepository.getAll();
    }

    public Optional<Motorbike> getMotorbike(int id){
        return motorbikeRepository.getMotorbike(id);
    }

    public Motorbike save(Motorbike motorbike){
        if(validarCampos(motorbike)){
            if(motorbike.getId()==null){
                return motorbikeRepository.save(motorbike);
            }else {
                Optional<Motorbike> motorbikeEncontrado= getMotorbike(motorbike.getId());
                if(motorbikeEncontrado.isEmpty()){
                    return motorbikeRepository.save(motorbike);
                }else {
                    return motorbike;
                }
            }
        }
        return motorbike;
    }
    public Motorbike update(Motorbike motorbike){
        if(validarCampos(motorbike)) {
            if (motorbike.getId() != null) {
                Optional<Motorbike> motorbikeEncontrado = getMotorbike(motorbike.getId());
                if (!motorbikeEncontrado.isEmpty()) {
                    if (motorbike.getName() != null) {
                        motorbikeEncontrado.get().setName(motorbike.getName());
                    }
                    if (motorbike.getBrand() != null) {
                        motorbikeEncontrado.get().setBrand(motorbike.getBrand());
                    }
                    if (motorbike.getYear() != null) {
                        motorbikeEncontrado.get().setYear(motorbike.getYear());
                    }
                    if (motorbike.getDescription() != null) {
                        motorbikeEncontrado.get().setDescription(motorbike.getDescription());
                    }
                    if (motorbike.getCategory() != null) {
                        motorbikeEncontrado.get().setCategory(motorbike.getCategory());
                    }
                    return motorbikeRepository.save(motorbikeEncontrado.get());
                }

            }
            return motorbike;
        }
        return motorbike;
    }

    public boolean delete(int id){
        Boolean resultado = getMotorbike(id).map(elemento ->{
         motorbikeRepository.delete(elemento);
            return true;
        }).orElse(false);
        return resultado;
    }

    public boolean validarCampos(Motorbike motorbike){
        return (motorbike.getBrand().length()<= 45 && motorbike.getName().length()<=45 &&
                String.valueOf(motorbike.getYear()).length()==4 && motorbike.getDescription().length()<=250);
    }
}




