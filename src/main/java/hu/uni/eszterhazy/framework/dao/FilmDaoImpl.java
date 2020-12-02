package hu.uni.eszterhazy.framework.dao;

import hu.uni.eszterhazy.framework.model.Film;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class FilmDaoImpl implements FilmDao {

    private final FilmRepository filmRepository;

    @Override
    public Collection<Film> readAll() {
        return StreamSupport.stream(filmRepository.findAll().spliterator(), false).map((filmEntity -> new Film(
                    filmEntity.getTitle(),
                    filmEntity.getDescription(),
                    filmEntity.getRelease_year(),
                    filmEntity.getYear(),
                    filmEntity.getRental_duration(),
                    filmEntity.getRental_rate(),
                    filmEntity.getLength(),
                    filmEntity.getReplacement_cost())
        )).collect(Collectors.toList());
    }

    //@Override
   //public void printFilms() {
   //    System.out.println("Repository" + filmRepository);
   //    StreamSupport.stream(filmRepository.findAll().spliterator(), false).forEach((filmEntity -> {
   //        System.out.println(filmEntity);
   //    }));
   //}
}
