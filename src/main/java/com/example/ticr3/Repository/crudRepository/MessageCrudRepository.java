package com.example.ticr3.Repository.crudRepository;

import com.example.ticr3.Entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {

}