package com.example.dorbit.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class Restaurant {
    private String id;
    private Address address;
    private List <Grade> grades;
    private String name;
    private String restaurant_id;
    private String borough;
    private String cuisine;

    public Restaurant(String id, Address address, List<Grade> grades, String name, String restaurant_id, String borough, String cuisine) {
        this.id = id;
        this.address = address;
        this.grades = grades;
        this.name = name;
        this.restaurant_id = restaurant_id;
        this.borough = borough;
        this.cuisine = cuisine;
    }
}
