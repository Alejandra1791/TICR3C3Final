package com.example.ticr3.Controller;

import com.example.ticr3.Entities.Motorbike;
import com.example.ticr3.Service.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/Costume")
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MotorbikeController {

    @Autowired
    private MotorbikeService motorbikeService;

    @GetMapping("/all")
    public List<Motorbike> getAll(){
        return motorbikeService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Motorbike> getCostume(@PathVariable("id") int id){
        return motorbikeService.getMotorbike(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike save(@RequestBody Motorbike motorbike){
        return motorbikeService.save(motorbike);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike update(@RequestBody Motorbike motorbike){
        return motorbikeService.update(motorbike);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable("id") int id){
        return motorbikeService.delete(id);
    }
}
