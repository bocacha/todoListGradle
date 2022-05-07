package demo.react.todolist.dto;

import demo.react.todolist.entity.Todo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class TodoDto implements Serializable {

    private Integer id;
    private String content;
    private Boolean status;

    public static List<TodoDto> transform(List<Todo> todos){
        return todos.stream().map(TodoDto::transform).collect(Collectors.toList());
    }

    public static TodoDto transform(Todo todo){
        TodoDto dto = new TodoDto();
        BeanUtils.copyProperties(todo, dto);
        return dto;
    }

    public Todo convert() {
        Todo todo = new Todo();
        BeanUtils.copyProperties(this, todo);
        return todo;
    }
}