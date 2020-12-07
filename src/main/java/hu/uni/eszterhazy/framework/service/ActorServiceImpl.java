package hu.uni.eszterhazy.framework.service;

import hu.uni.eszterhazy.framework.dao.ActorDao;
import hu.uni.eszterhazy.framework.model.Actor;
import hu.uni.eszterhazy.framework.model.Category;
import hu.uni.eszterhazy.framework.model.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService{
    private final ActorDao dao;

    @Override
    public Collection<Actor> listAll() {
        return dao.readAll();
    }

    @Override
    public String createActor(Actor actor) {
        for (Actor A : dao.readAll()) {
            if(A.getFirst_name().equals(actor.getFirst_name()) && A.getLast_name().equals(actor.getLast_name())){
                return "Error : " + actor.getFirst_name() + " " + actor.getLast_name() + " Actor already exists";
            }
        }
        dao.createActor(actor);
        return "Actor : "  + actor.getFirst_name()+ " " + actor.getLast_name() + " Created";
    }

   // @Override
   // public String deleteActor(String first_name, String last_name) {
   //     for (Actor A : dao.readAll()) {
   //         if(A.getFirst_name().equals(first_name) && A.getLast_name().equals(last_name)){
   //             dao.deleteActor(first_name,last_name);
   //             return "Actor "+ first_name + " " + last_name + " was deleted";
   //         }
   //     }
   //     return "Actor does not exist ";
   // }


}
