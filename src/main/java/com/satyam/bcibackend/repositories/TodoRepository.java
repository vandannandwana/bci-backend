package com.satyam.bcibackend.repositories;


import com.satyam.bcibackend.dto.TodoDto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TodoRepository extends MongoRepository<TodoDto,String> {

    List<TodoDto> findAllByType(String type);

}
