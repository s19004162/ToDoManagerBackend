package com.tk.todoapp.todoapp.dto;
import lombok.Data;

@Data
public class ToDo {

    private Long id;
    private String subject;
    private String text;
    private Boolean done;

}
