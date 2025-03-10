package com.satyam.bcibackend.service;

import com.satyam.bcibackend.dto.TodoDto;
import com.satyam.bcibackend.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

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


    public List<TodoDto> getAllTodosByType(String type) {

        return todoRepo.findAllByType(type);

    }

    public void changeState(String todoId, Boolean isActive) throws Exception {
        Optional<TodoDto> temp = todoRepo.findById(todoId);

        if (temp.isEmpty()){
            throw new Exception("No Todo Found");
        }

        TodoDto todo = temp.get();
        todo.setActive(isActive);
        todoRepo.save(todo);


    }
}
