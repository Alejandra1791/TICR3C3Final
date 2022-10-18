package com.example.ticr3.Repository.crudRepository;

import com.example.ticr3.Entities.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository  extends CrudRepository<Score, Integer> {
}