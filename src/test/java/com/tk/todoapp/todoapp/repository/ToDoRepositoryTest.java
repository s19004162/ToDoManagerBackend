//package com.tk.todoapp.todoapp.repository;
//
//import com.tk.todoapp.todoapp.dto.ToDo;
//import org.junit.jupiter.api.Test;
//import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.jdbc.Sql;
//
//import java.util.Collection;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@MybatisTest
//public class ToDoRepositoryTest {
//
//    @Autowired
//    ToDoRepository toDoRepository;
//
//    @Test
//    @Sql(statements = "INSERT INTO ToDo(subject, text, done) VALUES ('TEST TODO', 'This is a test ToDO for JUNIT Testing', false)")
//    void testFindAll() {
//        // execute
//        Collection<ToDo> todos = toDoRepository.findAll();
//
//        // assert
//        assertThat(todos)
//                .hasSize(1)
//                .extracting(ToDo::getToDosubject, ToDo::getToDotext, ToDo::getToDodone)
//                .containsExactly(tuple('TEST TODO', 'This is a test ToDO for JUNIT Testing', false));
//    }
//}
