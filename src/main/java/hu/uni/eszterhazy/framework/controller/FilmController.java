package hu.uni.eszterhazy.framework.controller;

import hu.uni.eszterhazy.framework.model.Film;
import hu.uni.eszterhazy.framework.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping(value = "/film")
@RestController
@RequiredArgsConstructor
public class FilmController {

    private final FilmService service;

    @GetMapping(value = {"/", "/all"})
    public Collection<Film> getAll(){
        return service.listAll();
    }

    @GetMapping(value = {"/language/{language}"})
    public Collection<Film> getAll(@PathVariable(name = "language") String language){
        return service.listAllByLanguage(language);
    }

    @PostMapping(value = {"/create/{title}/{description}/{release_year}/{language}/{rental_duration}/{rental_rate}/{length}/{replacement_cost}/{rating}/{special_features}"})
    public String createFilm(
            @PathVariable(name = "title") String title,
            @PathVariable(name = "description") String description,
            @PathVariable(name = "release_year") int release_year,
            @PathVariable(name = "language") String language,
            @PathVariable(name = "rental_duration") int rental_duration,
            @PathVariable(name = "rental_rate") double rental_rate,
            @PathVariable(name = "length") int length,
            @PathVariable(name = "replacement_cost") double replacement_cost,
            @PathVariable(name = "rating") String rating,
            @PathVariable(name = "special_features") String special_features
    ){
        return service.createFilm(title, description, release_year, language, rental_duration, rental_rate, length, replacement_cost, rating, special_features);
    }

}
