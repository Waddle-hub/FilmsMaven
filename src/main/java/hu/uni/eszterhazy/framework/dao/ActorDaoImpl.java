package hu.uni.eszterhazy.framework.dao;

import hu.uni.eszterhazy.framework.dao.entity.ActorEntity;
import hu.uni.eszterhazy.framework.dao.repositories.ActorRepository;
import hu.uni.eszterhazy.framework.model.Actor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActorDaoImpl implements ActorDao {

    private final ActorRepository actorRepository;

    private Timestamp getCurrentTime(){
        return new Timestamp((new Date()).getTime());
    }

    @Override
    public Collection<Actor> readAll() {
        return StreamSupport.stream(actorRepository.findAll().spliterator(), false).map( (actorEntity -> new Actor(
                actorEntity.getFirst_name(),
                actorEntity.getLast_name()
        ))).collect(Collectors.toList());
    }

    @Override
    public void createActor(Actor actor) {
        actorRepository.save(ActorEntity.builder()
                .first_name(actor.getFirst_name())
                .last_name(actor.getLast_name())
                .last_update(getCurrentTime())
                .build());
    }
}
