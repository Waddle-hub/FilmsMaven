package hu.uni.eszterhazy.framework.service;

import hu.uni.eszterhazy.framework.dao.FilmDao;
import hu.uni.eszterhazy.framework.model.Film;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService{
    private final FilmDao filmDao;

    @Override
    public Collection<Film> listAll() {
        return filmDao.readAll();
    }

    @Override
    public Collection<Film> listAllByLanguage(String language) {
        return filmDao.readAll().stream()
                .filter( film -> film.getLanguage().equals(language))
                .collect(Collectors.toList());
    }

    @Override
    public String createFilm(String title, String description, int release_year, String language, int rental_duration, double rental_rate, int length, double replacement_cost, String rating, String special_features) {
        for (Film F : filmDao.readAll()) {
            if(F.getTitle().equals(title)){
                return "This film already exists";
            }
        }
        filmDao.createFilm(new Film(title, description, release_year, language, rental_duration, rental_rate, length, replacement_cost, rating, special_features));
        return "Film " + title + " was created";
    }
}
