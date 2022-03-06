package com.tk.todoapp.todoapp.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ToDo {

    private Long id;
    private String subject;
    private String text;
    private Boolean done;

}
