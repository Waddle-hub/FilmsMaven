package hu.uni.eszterhazy.framework.controller;

import hu.uni.eszterhazy.framework.model.Actor;
import hu.uni.eszterhazy.framework.model.Film;
import hu.uni.eszterhazy.framework.model.Language;
import hu.uni.eszterhazy.framework.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping(value = "/actor")
@RestController
@RequiredArgsConstructor
public class ActorController {
    private final ActorService service;

    @GetMapping(value = {"/", "/all"})
    public Collection<Actor> getAll(){
        return service.listAll();
    }

    @PostMapping(value = "/create/{actor_first}/{actor_last}")
    public String createActor(@PathVariable(name = "actor_first") String A_first, @PathVariable(name = "actor_last") String A_last){
        return service.createActor(new Actor(A_first,A_last));
    }

   // @DeleteMapping(value = "/delete/{first_name}/{last_name}")
   // public String deleteActor(@PathVariable(name = "first_name")String first_name, @PathVariable(name = "last_name")String last_name){
   //     return service.deleteActor(first_name,last_name);
   // }

}
