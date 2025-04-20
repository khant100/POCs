package com.service.rest.restFul_web_service.service;

import com.service.rest.restFul_web_service.DTO.Todo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todoList = new ArrayList();
    private static Long id =0l;

    static{
        todoList.add(new Todo(++id,"vyas","to complete java course 1", new Date(),false));
        todoList.add(new Todo(++id,"username","to complete Angular course 3", new Date(),false));
        todoList.add(new Todo(++id,"vyas","to complete DSA course", new Date(),false));

    }

    public List<Todo> findAll(){
        return todoList;
    }

    public Todo save(Todo todo){
        if(todo.getId()==-1||todo.getId()==0){
            todo.setId(++id);
            todoList.add(todo);

        }else {
            deleatById(todo.getId());
            todoList.add(todo);
        }
        return todo;
    }
    public Todo deleatById(Long id){
        Todo todo = findById(id);
        if(todo==null)return null;
        if(todoList.remove(todo)){
            return todo;
        }
        return null;
    }
        public Todo findById(Long id){
        for( Todo todo : todoList){
            if(todo.getId().equals(id)){
                return todo;
            }
        }
        return null;
}
}
