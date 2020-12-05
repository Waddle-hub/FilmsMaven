package hu.uni.eszterhazy.framework.dao;

import hu.uni.eszterhazy.framework.dao.repositories.LanguageRepository;
import hu.uni.eszterhazy.framework.model.Language;
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
public class LanguageDaoImpl implements LanguageDao{

    private final LanguageRepository languageRepository;

    private Timestamp getCurrentTime(){
        return new Timestamp((new Date()).getTime());
    }

    @Override
    public Collection<Language> readAll() {
        return StreamSupport.stream(languageRepository.findAll().spliterator(), false).map((languageEntity -> new Language(
                languageEntity.getName()
        ))).collect(Collectors.toList());
    }
}
