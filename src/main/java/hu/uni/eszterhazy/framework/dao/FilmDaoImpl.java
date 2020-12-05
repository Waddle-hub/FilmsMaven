package hu.uni.eszterhazy.framework.dao;

import hu.uni.eszterhazy.framework.dao.entity.FilmEntity;
import hu.uni.eszterhazy.framework.dao.entity.LanguageEntity;
import hu.uni.eszterhazy.framework.dao.repositories.FilmRepository;
import hu.uni.eszterhazy.framework.dao.repositories.LanguageRepository;
import hu.uni.eszterhazy.framework.model.Film;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class FilmDaoImpl implements FilmDao {

    private final FilmRepository filmRepository;
    private final LanguageRepository languageRepository;

    @Override
    public Collection<Film> readAll() {
        return StreamSupport.stream(filmRepository.findAll().spliterator(), false).map((filmEntity -> new Film(
                    filmEntity.getTitle(),
                    filmEntity.getDescription(),
                    filmEntity.getRelease_year(),
                    filmEntity.getLanguage().getName(),
                    filmEntity.getRental_duration(),
                    filmEntity.getRental_rate(),
                    filmEntity.getLength(),
                    filmEntity.getReplacement_cost(),
                    filmEntity.getRating(),
                    filmEntity.getSpecial_features()
        ))).collect(Collectors.toList());
    }

    private LanguageEntity queryByName(String name){
        if(languageRepository.findByName(name).isEmpty()){
            log.info("{} has not been found", name);
            languageRepository.save(new LanguageEntity(0, name, getCurrentTime()));
        }
        return languageRepository.findByName(name).get();
    }

    private Timestamp getCurrentTime(){
        return new Timestamp((new Date()).getTime());

    }

    @Override
    public void createFilm(Film film) {
        LanguageEntity language = languageRepository.findByName(film.getLanguage()).get();
        filmRepository.save(FilmEntity.builder()
                .title(film.getTitle())
                .description(film.getDescription())
                .release_year(film.getRelease_year())
                .language(queryByName(film.getLanguage()))
                .rental_duration(film.getRental_duration())
                .rental_rate(film.getRental_rate())
                .length(film.getLength())
                .replacement_cost(film.getReplacement_cost())
                .rating(film.getRating())
                .special_features(film.getSpecial_features())
                .last_update(getCurrentTime())
                .build());
    }

}
