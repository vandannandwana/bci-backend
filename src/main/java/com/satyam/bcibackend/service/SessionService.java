package com.satyam.bcibackend.service;

import com.satyam.bcibackend.dto.SessionDto;
import com.satyam.bcibackend.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    SessionRepository sessionRepo;


    public List<SessionDto> getAllSessions() {

        return sessionRepo.findAll();

    }

    public List<SessionDto> getSessionByName(String name) {

        return sessionRepo.findByName(name);

    }

    public SessionDto getSessionById(String id){

        Optional<SessionDto> optionalSession  =sessionRepo.findById(id);

        return optionalSession.orElse(null);


    }

    public boolean addSession(SessionDto session) {

        try {
            sessionRepo.save(session);
            return true;
        }catch (Exception e) {
            return false;
        }
    }


    public boolean addSessions(List<SessionDto> sessions) {

        try {
            sessionRepo.saveAll(sessions);
            return true;
        }catch (Exception e){
            return false;
        }


    }
}
