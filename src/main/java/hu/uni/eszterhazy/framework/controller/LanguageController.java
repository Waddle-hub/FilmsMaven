package hu.uni.eszterhazy.framework.controller;

import hu.uni.eszterhazy.framework.model.Film;
import hu.uni.eszterhazy.framework.model.Language;
import hu.uni.eszterhazy.framework.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping(value = "/language")
@RestController
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService service;

    @GetMapping(value = {"/", "/all"})
    public Collection<Language> getAll(){
        return service.listAll();
    }

    @PostMapping(value = "/create/{language}")
    public String createLanguage(@PathVariable(name = "language") String L){
        return service.createLanguage(new Language(L));
    }

    @DeleteMapping(value = "/delete/{name}")
    public String deleteByName(@PathVariable(name = "name") String name){
        return service.deleteLanguage(name);
    }

}
