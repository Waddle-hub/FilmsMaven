package hu.uni.eszterhazy.framework.dao;


import hu.uni.eszterhazy.framework.model.Actor;

import java.util.Collection;

public interface ActorDao {
    Collection<Actor> readAll();
}
