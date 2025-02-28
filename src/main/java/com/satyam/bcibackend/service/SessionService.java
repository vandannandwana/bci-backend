package com.satyam.bcibackend.service;

import com.satyam.bcibackend.dto.RecordDto;
import com.satyam.bcibackend.dto.SessionDto;
import com.satyam.bcibackend.dto.SessionUpdateRequest;
import com.satyam.bcibackend.dto.UserDto;
import com.satyam.bcibackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SessionService {
    @Autowired
    UserRepository userRepo;
    public boolean updateSession(SessionUpdateRequest request) {
        Optional<UserDto> optionalUser = userRepo.findById(request.getUserId());

        if(optionalUser.isPresent()){
            UserDto user = optionalUser.get();
            List<SessionDto> sessions = user.getSessions();


            if(sessions == null){

                List<SessionDto> newsessions = new ArrayList<>();

                SessionDto newSession = new SessionDto();
                newSession.setId(request.getSessionId());
                newSession.setSessionName(request.getSessionName());
                newSession.setAverageTime(request.getTime());
                newSession.setLowestTime(request.getTime());
                newSession.setHighestTime(request.getTime());
                newSession.setSessionTime(request.getSessionTime());
                long currentSum = 0;

                for (int val :request.getValues()){
                    currentSum += val;
                }

                currentSum /= request.getValues().size();

                newsessions.add(newSession);
                user.setSessions(newsessions);
                userRepo.save(user);
                return true;

            }



            for(SessionDto session :sessions){

                if(Objects.equals(session.getId(), request.getSessionId())){

                    if(request.getTime() > session.getHighestTime()){
                        session.setHighestTime(request.getTime());
                    }

                    if(request.getTime() < session.getLowestTime()){
                        session.setLowestTime(request.getTime());
                    }

                    session.setAverageTime((session.getAverageTime()+ request.getTime())/2);
                    long currentSum = 0;

                    for (int val :request.getValues()){
                        currentSum += val;
                    }

                    currentSum /= request.getValues().size();

                    session.setAverageConcentration((session.getAverageConcentration()+currentSum)/2);

                    userRepo.save(user);
                    return true;
                }


            }

            SessionDto newSession = new SessionDto();
            newSession.setId(request.getSessionId());
            newSession.setSessionName(request.getSessionName());
            newSession.setAverageTime(request.getTime());
            newSession.setLowestTime(request.getTime());
            newSession.setHighestTime(request.getTime());
            newSession.setSessionTime(request.getSessionTime());
            long currentSum = 0;

            for (int val :request.getValues()){
                currentSum += val;
            }

            currentSum /= request.getValues().size();
            newSession.setAverageConcentration(currentSum);
            user.getSessions().add(newSession);
            userRepo.save(user);

            return true;

        }



        return false;
    }

}
