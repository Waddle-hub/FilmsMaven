package hu.uni.eszterhazy.framework.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "film", schema = "sakila")
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "film_id")
    private int id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private int year;
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
    //@Column
    // private int rating; enum need to implement with better understanding
    //@Column
    // private int special_features; set need to implement with better understanding
    @Column
    private Timestamp last_update;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private LanguageEntity language;

    @ManyToMany
    private Set<CategoryEntity> category;

    @ManyToMany
    private Set<ActorEntity> actor;

}
