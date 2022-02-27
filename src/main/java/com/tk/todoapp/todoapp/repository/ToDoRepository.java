package com.tk.todoapp.todoapp.repository;

import com.tk.todoapp.todoapp.dto.ToDo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ToDoRepository {

    @Select("SELECT id, subject, text, done FROM ToDo WHERE id = #{id}")
    Optional<ToDo> findById(Long id);

    @Select("SELECT id, subject, text, done FROM ToDo")
    List<ToDo> findAll();

    @Insert("INSERT INTO ToDo(id, subject, text, done) VALUES (#{id}, #{subject}, #{text}, #{done})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void create(ToDo todo);

    @Update("UPDATE ToDo SET subject=#{subject}, text=#{text}, done=#{done} WHERE id=#{id}")
    boolean updateById(ToDo todo);

    @Delete("DELETE FROM ToDo WHERE id=#{id}")
    void deleteById(Long id);

    @Select("SELECT COUNT(*) FROM ToDo WHERE done=#{done}")
    long countByDone(boolean done);

}
