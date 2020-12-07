package hu.uni.eszterhazy.framework.controller;

import hu.uni.eszterhazy.framework.model.Category;
import hu.uni.eszterhazy.framework.model.Film;
import hu.uni.eszterhazy.framework.model.Language;
import hu.uni.eszterhazy.framework.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping(value = "/category")
@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping(value = {"/", "/all"})
    public Collection<Category> getAll(){
        return service.listAll();
    }

    @PostMapping(value = "/create/{category}")
    public String createCategory(@PathVariable(name = "category") String C){
        return service.createCategory(new Category(C));
    }

    @DeleteMapping(value = "delete/{name}")
    public String deleteCategory(@PathVariable(name="name") String name){
        return service.deleteCategory(name);
    }

}
