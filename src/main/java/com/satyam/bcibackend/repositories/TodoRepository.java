package com.satyam.bcibackend.repositories;


import com.satyam.bcibackend.dto.TodoDto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<TodoDto,String> {



}
