package hu.uni.eszterhazy.framework.service;

import hu.uni.eszterhazy.framework.model.Actor;

import java.util.Collection;

public interface ActorService {
    Collection<Actor> listAll();
    String createActor(Actor actor);
    //String deleteActor(String first_name, String last_name);
}
