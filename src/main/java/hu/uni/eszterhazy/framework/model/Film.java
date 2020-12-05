package hu.uni.eszterhazy.framework.model;

import hu.uni.eszterhazy.framework.dao.entity.enumandsetHelp.Rating;
import hu.uni.eszterhazy.framework.dao.entity.enumandsetHelp.SpecialFeatures;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Film {

    private String title;
    private String description;
    private int release_year;
    private String language;
    private int rental_duration;
    private double rental_rate;
    private int length;
    private double replacement_cost;
    private Rating rating;
    private SpecialFeatures special_features;

}
