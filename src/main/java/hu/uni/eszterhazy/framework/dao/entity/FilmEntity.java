package hu.uni.eszterhazy.framework.dao.entity;

import hu.uni.eszterhazy.framework.dao.entity.enumandsetHelp.Rating;
import hu.uni.eszterhazy.framework.dao.entity.enumandsetHelp.RatingConverter;
import hu.uni.eszterhazy.framework.dao.entity.enumandsetHelp.SpecialFeatures;
import hu.uni.eszterhazy.framework.dao.entity.enumandsetHelp.SpecialFeaturesConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "film", schema = "sakila")
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private int id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private int release_year;
    //@Column
    //private int original_language_id;
    @Column
    private int rental_duration;
    @Column
    private double rental_rate;
    @Column
    private int length;
    @Column
    private double replacement_cost;
    @Column
    private Timestamp last_update;

    @Convert(converter = RatingConverter.class)
    private Rating rating;

    @Convert(converter = SpecialFeaturesConverter.class)
    private SpecialFeatures special_features;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private LanguageEntity language;

    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<CategoryEntity> category;

    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<ActorEntity> actor = new HashSet<>();

}
