package com.satyam.bcibackend.controller;

import com.satyam.bcibackend.dto.TodoDto;
import com.satyam.bcibackend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping("/createTodo")
    public ResponseEntity<String> createTodo(@RequestBody TodoDto todo){

        if(todoService.createTodo(todo)){
            return ResponseEntity.ok("Todo Created Successfully");
        }else {
            return ResponseEntity.internalServerError().body("Todo is not Created successfully");
        }


    }


    @PostMapping("/createTodos")
    public ResponseEntity<String> createTodos(@RequestBody List<TodoDto> todos){

        if(todoService.addAllTodos(todos)){
            return ResponseEntity.ok("Todos Created Successfully");
        }else {
            return ResponseEntity.internalServerError().body("Todos is not Created successfully");
        }


    }


    @PostMapping("/deleteTodo")
    public ResponseEntity<String> deleteTodo(@RequestBody TodoDto todo){

        if(todoService.deleteTodo(todo)){
            return ResponseEntity.ok("Todo Deleted Successfully");
        }else {
            return ResponseEntity.internalServerError().body("Todo is not Deleted successfully");
        }


    }

    @PostMapping("/updateTodo")
    public ResponseEntity<String> updateTodo(@RequestBody TodoDto todo){

        if(todoService.updateTodo(todo)){
            return ResponseEntity.ok("Todo Updated Successfully");
        }else {
            return ResponseEntity.internalServerError().body("Todo is not Updated successfully");
        }


    }

    @GetMapping("/getTodos")
    public ResponseEntity<List<TodoDto>> getTodos(){
        List<TodoDto> todos = todoService.getAllTodos();

        if(!todos.isEmpty()){
            return ResponseEntity.ok(todos);
        }else {
            return ResponseEntity.noContent().build();
        }


    }


    @GetMapping("/getTodos/{type}")
    public ResponseEntity<List<TodoDto>> getTodosByType(@PathVariable("type") String type){

        try{
            List<TodoDto> todos = todoService.getAllTodosByType(type);

            if(!todos.isEmpty()){
                return ResponseEntity.ok(todos);
            }else {
                return ResponseEntity.noContent().build();
            }
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }


    }


    @PostMapping("/changeTodoState")
    public ResponseEntity<String> changeTodoState(@Param("todoId") String todoId,@Param("isActive") Boolean isActive){
        try{
            todoService.changeState(todoId,isActive);
            return ResponseEntity.ok("State Changed to "+isActive);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error Occured"+e.getMessage());
        }

    }




}
