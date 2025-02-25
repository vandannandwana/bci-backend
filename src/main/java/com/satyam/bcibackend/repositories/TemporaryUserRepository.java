package com.satyam.bcibackend.repositories;

import com.satyam.bcibackend.dto.TemporaryUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemporaryUserRepository extends MongoRepository<TemporaryUser,String> {


    public TemporaryUser findByPhoneNumber(String phoneNumber);


}
