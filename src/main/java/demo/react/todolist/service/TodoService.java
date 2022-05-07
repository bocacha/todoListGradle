package demo.react.todolist.service;

import demo.react.todolist.entity.Todo;
import demo.react.todolist.repository.TodoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@NoArgsConstructor
@AllArgsConstructor
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public List<Todo> getAllTodo(){
        return this.repository.findAll();
    }

    public Todo saveTodo(Todo todo) {
        return this.repository.save(todo);
    }

    public Todo findTodoById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Boolean deleteTodoById(Integer id) {
        try {
            repository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
