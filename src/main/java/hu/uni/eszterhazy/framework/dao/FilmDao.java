package hu.uni.eszterhazy.framework.dao;

import hu.uni.eszterhazy.framework.model.Film;

import java.util.Collection;

public interface FilmDao {
    Collection<Film> readAll();
    void createFilm(Film film);
}
