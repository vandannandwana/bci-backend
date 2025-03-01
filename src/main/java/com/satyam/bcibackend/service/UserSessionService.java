package com.satyam.bcibackend.service;

import com.satyam.bcibackend.dto.UserDto;
import com.satyam.bcibackend.dto.UserSessionDto;
import com.satyam.bcibackend.dto.UserSessionRequestDto;
import com.satyam.bcibackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserSessionService {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;


    public boolean addSession(UserSessionRequestDto requestDto) {

        Optional<UserDto> optionalUser = Optional.ofNullable(userService.findUserById(requestDto.getUserId()));

        if(optionalUser.isEmpty()){
            System.out.println("User Not Exist With this userId");
            return false;
        }

        try {
            UserDto user = optionalUser.get();

            UserSessionDto userSessionDto = new UserSessionDto();

            userSessionDto.setSessionId(requestDto.getSessionId());
            userSessionDto.setSessionName(requestDto.getSessionName());
            userSessionDto.setUserId(requestDto.getUserId());
            userSessionDto.setActualDuration(requestDto.getActualDuration());
            userSessionDto.setListenDuration(requestDto.getListenDuration());
            userSessionDto.setSelectedThreshold(requestDto.getSelectedThreshold());
            userSessionDto.setFocusValues(requestDto.getFocusValues());

            List<Integer> overThresholdValues = new ArrayList<>();

            for (int focusValue : requestDto.getFocusValues()) {

                if (focusValue > requestDto.getSelectedThreshold()) {

                    overThresholdValues.add(focusValue);

                }

            }
            userSessionDto.setOverThresholdValues(overThresholdValues);
            userSessionDto.setOverThresholdCount((long) overThresholdValues.size());

            if(user.getSessions() == null){
                ArrayList<UserSessionDto> newList = new ArrayList<>();
                newList.add(userSessionDto);
                user.setSessions(newList);
                userRepository.save(user);
            }
            else{
                List<UserSessionDto> sessions = user.getSessions();
                sessions.add(userSessionDto);
                userRepository.save(user);

            }

            return true;
        }catch (Exception e){
            System.out.println("Error While adding Sessions"+e.getMessage());
            return false;
        }

    }
}
