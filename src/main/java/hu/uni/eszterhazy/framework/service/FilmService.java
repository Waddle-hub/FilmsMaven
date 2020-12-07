package hu.uni.eszterhazy.framework.service;

import hu.uni.eszterhazy.framework.model.Film;

import java.util.Collection;

public interface FilmService {
    Collection<Film> listAll();

    Collection<Film> listAllByLanguage(String language);

    String createFilm(String title,
                      String description,
                      int release_year,
                      String language,
                      int rental_duration,
                      double rental_rate,
                      int length,
                      double replacement_cost,
                      String rating,
                      String special_features);
}
