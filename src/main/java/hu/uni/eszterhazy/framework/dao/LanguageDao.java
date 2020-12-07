package hu.uni.eszterhazy.framework.dao;

import hu.uni.eszterhazy.framework.model.Language;

import java.util.Collection;

public interface LanguageDao {
    Collection<Language> readAll();
    void createLanguage(Language language);
    void deleteLanguagebyName(String name);
}
