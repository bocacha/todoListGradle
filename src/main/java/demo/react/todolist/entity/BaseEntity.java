package demo.react.todolist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
class BaseEntity implements Serializable {
    @CreatedDate
    private ZonedDateTime creatTime = ZonedDateTime.now();

    @LastModifiedDate
    private ZonedDateTime updateTime;
}