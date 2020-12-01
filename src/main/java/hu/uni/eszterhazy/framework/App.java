package hu.uni.eszterhazy.framework;

import hu.uni.eszterhazy.framework.dao.FilmDao;
import hu.uni.eszterhazy.framework.dao.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.stream.StreamSupport;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner
{
    private ApplicationContext context;

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world");

        FilmDao dao = context.getBean(FilmDao.class);
        dao.printFilms();

    }
}
