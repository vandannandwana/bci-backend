package com.satyam.bcibackend.repositories;

import com.satyam.bcibackend.dto.SessionDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SessionRepository extends MongoRepository<SessionDto, String> {

    // MongoDB equivalent of: SELECT * FROM song WHERE song.title LIKE '%tere%'
    @Query("{ 'sessionName': { $regex: ?0, $options: 'i' } }")
    List<SessionDto> findByName(String sessionName);


}

