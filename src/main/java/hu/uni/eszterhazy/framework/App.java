package hu.uni.eszterhazy.framework;

import hu.uni.eszterhazy.framework.dao.ActorDao;
import hu.uni.eszterhazy.framework.dao.CategoryDao;
import hu.uni.eszterhazy.framework.dao.FilmDao;
import hu.uni.eszterhazy.framework.dao.LanguageDao;
import hu.uni.eszterhazy.framework.dao.entity.enumandsetHelp.Rating;
import hu.uni.eszterhazy.framework.dao.entity.enumandsetHelp.SpecialFeatures;
import hu.uni.eszterhazy.framework.dao.repositories.FilmRepository;
import hu.uni.eszterhazy.framework.model.Film;
import hu.uni.eszterhazy.framework.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner
{
    @Autowired
    private ApplicationContext context;

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world");

        FilmDao filmDao = context.getBean(FilmDao.class);
        ActorDao actorDao = context.getBean(ActorDao.class);
        CategoryDao categoryDao = context.getBean(CategoryDao.class);
        LanguageDao languageDao = context.getBean(LanguageDao.class);


        //actorDao.readAll().forEach(System.out::println);
        //categoryDao.readAll().forEach(System.out::println);
        //filmDao.readAll().forEach(System.out::println);
        //languageDao.readAll().forEach(System.out::println);

       // context.getBean(FilmRepository.class).findAll().stream().forEach(System.out::println);

       // filmDao.createFilm(new Film(
       //         "Wades grand adventure",
       //         "The adventure of a young programmer named wade who goes on an adventure",
       //         1999,
       //         "Hungarian",
       //         10,
       //         5.66,
       //         120,
       //         10.55,
       //         Rating.R,
       //         SpecialFeatures.TRAILERS
       // ));

    }
}
