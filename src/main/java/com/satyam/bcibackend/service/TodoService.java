package com.satyam.bcibackend.service;

import com.satyam.bcibackend.dto.TodoDto;
import com.satyam.bcibackend.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepo;

    public boolean createTodo(TodoDto todo){
        try {

            todoRepo.save(todo);

            return true;
        }catch (Exception e){
            return false;
        }

    }

    public boolean deleteTodo(TodoDto todo){
        try {

            todoRepo.delete(todo);

            return true;
        }catch (Exception e){
            return false;
        }

    }

    public boolean updateTodo(TodoDto todo){
        try {

            todoRepo.save(todo);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public List<TodoDto> getAllTodos(){

        return todoRepo.findAll();

    }

    public boolean addAllTodos(List<TodoDto> todos){

        try {

            todoRepo.saveAll(todos);
            return true;
        }catch (Exception e){
            return false;
        }

    }



}
