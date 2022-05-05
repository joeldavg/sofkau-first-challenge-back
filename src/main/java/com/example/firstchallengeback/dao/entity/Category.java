package com.example.firstchallengeback.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Category")
@Table(name = "category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "categoryId")
    private List<Task> tasks;

}
