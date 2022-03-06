package com.tk.todoapp.todoapp.controller;

import com.tk.todoapp.todoapp.dto.ToDo;
import com.tk.todoapp.todoapp.repository.ToDoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ToDoController {

    @Autowired
    ToDoRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ToDoController.class);

    @RequestMapping(value="/todo", method = RequestMethod.GET)
    public List<ToDo> findAll() {
        return repository.findAll();
    }

    @RequestMapping(value="/todo/{id}", method = RequestMethod.GET)
    public Optional<ToDo> findById(@PathVariable("id") Long id) {
        LOGGER.info("Finding ToDo by ID:"+id);
        return repository.findById(id);
    }

    @RequestMapping(value="/todo", method = RequestMethod.POST)
    public void create(@RequestBody ToDo todo) {
        LOGGER.info("Creating a ToDo");
        LOGGER.info(String.valueOf(todo));
        repository.create(todo);
    }

    @RequestMapping(value="/todo", method = RequestMethod.PUT)
    public void updateById(@RequestBody ToDo todo) {
        repository.updateById(todo);
    }

    @RequestMapping(value="/todo/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") String id) {
        Long Long_id = Long.valueOf(id);
        LOGGER.info("Delete a ToDo:" + Long_id);
        repository.deleteById(Long_id);
    }

}
