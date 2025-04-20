package com.service.rest.restFul_web_service.Controller;


import com.service.rest.restFul_web_service.DTO.Todo;
import com.service.rest.restFul_web_service.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/todos")
public class ToDoResourceController {


    @Autowired
    private TodoService todoService;
    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable  String username){
      return   todoService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodos(@PathVariable  String username,@PathVariable Long id){
        return  todoService.findById(id);
    }

    
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deletToDo(@PathVariable String username, @PathVariable Long id){
      Todo todo=  todoService.deleatById(id);
        if(todo!=null  ){
             return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateToDo(@PathVariable String username,@PathVariable Long id, @RequestBody Todo todo){
       Todo todo1= todoService.save(todo);
        return new ResponseEntity<Todo>(todo1, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Todo> createToDo(@PathVariable String username, @RequestBody Todo todo){
        Todo todo1= todoService.save(todo);

      URI uri=  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(todo1.getId()).toUri();

        return  ResponseEntity.created(uri).build();
    }

}

