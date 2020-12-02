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
@Table(name = "actor", schema = "sakila")
public class ActorEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "actor_id")
   private int id;
   @Column
   private String first_name;
   @Column
   private String last_name;
   @Column
   private Timestamp last_update;
   @ManyToMany(mappedBy = "actor")
   private Set<FilmEntity> film;
}
