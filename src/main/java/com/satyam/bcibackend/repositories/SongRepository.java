package com.satyam.bcibackend.repositories;

import com.satyam.bcibackend.userentity.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SongRepository extends MongoRepository<Song, String> {

    // MongoDB equivalent of: SELECT * FROM song WHERE song.title LIKE '%tere%'
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Song> searchBySong(String title);


}

