package demo.react.todolist.controller;

import demo.react.todolist.dto.TodoDto;
import demo.react.todolist.entity.Todo;
import demo.react.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoListController {
    @Autowired
    private TodoService service;

    @GetMapping
    public List<TodoDto> getAllTodo(){
        List<Todo> todos = service.getAllTodo();
        return TodoDto.transform(todos);
    }

    @PostMapping
    public TodoDto createTodo(@RequestBody TodoDto dto){
        Todo todo = dto.convert();
        Todo saved = service.saveTodo(todo);
        if (!ObjectUtils.isEmpty(saved)){
            return TodoDto.transform(saved);
        }
        return null;
    }

    @PutMapping("/{id}")
    public TodoDto updateTodo(@PathVariable("id") Integer id, @RequestBody TodoDto dto){
        Todo updatingTodo = service.findTodoById(id);
        if (!ObjectUtils.isEmpty(updatingTodo)){
            Todo todo = dto.convert();
            todo.setId(id);
            Todo updated = service.saveTodo(todo);
            return TodoDto.transform(updated);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(@PathVariable("id") Integer id){
        Boolean result = service.deleteTodoById(id);
        if (result){
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
