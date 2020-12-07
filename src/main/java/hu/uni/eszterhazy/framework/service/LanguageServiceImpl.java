package hu.uni.eszterhazy.framework.service;

import hu.uni.eszterhazy.framework.dao.LanguageDao;
import hu.uni.eszterhazy.framework.model.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    private final LanguageDao dao;

    @Override
    public Collection<Language> listAll() {
        return dao.readAll();
    }

    @Override
    public String createLanguage(Language language) {
        for (Language L : dao.readAll()) {
            if(L.getName().equals(language.getName())){
                return "Error : " + language + " Language already exists";
            }
        }
        dao.createLanguage(language);
        return "Language : " + language + " Created";
    }

    @Override
    public String deleteLanguage(String name) {
        for (Language L : dao.readAll()) {
            if(L.getName().equals(name)){
                dao.deleteLanguagebyName(name);
                return "Language "+ name +" was deleted";
            }
        }
        return "Language Does not exist ";
    }
}
