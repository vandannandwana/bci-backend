package com.satyam.bcibackend.repositories;

import com.satyam.bcibackend.dto.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface UserRepository extends MongoRepository<UserDto,String> {

    @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
    List<UserDto> findByNameRegex(String name);

}
