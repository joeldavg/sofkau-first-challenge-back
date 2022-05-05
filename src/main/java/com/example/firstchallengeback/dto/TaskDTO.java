package com.example.firstchallengeback.dto;

import lombok.Data;

@Data
public class TaskDTO {

    private Long id;
    private String message;
    private Boolean done;
    private Long categoryId;

}
