package hu.uni.eszterhazy.framework.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class FilmDaoImpl implements FilmDao {

    private final FilmRepository filmRepository;

   //@Override
   //public void printFilms() {
   //    System.out.println("Repository" + filmRepository);
   //    StreamSupport.stream(filmRepository.findAll().spliterator(), false).forEach((filmEntity -> {
   //        System.out.println(filmEntity);
   //    }));
   //}
}
