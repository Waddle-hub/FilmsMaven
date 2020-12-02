package hu.uni.eszterhazy.framework.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Film {

    private String title;
    private String description;
    private int release_year;
    private int year;
    private int rental_duration;
    private double rental_rate;
    private int length;
    private double replacement_cost;

}
