package hu.uni.eszterhazy.framework.service;

import hu.uni.eszterhazy.framework.model.Language;

import java.util.Collection;

public interface LanguageService {
    Collection<Language> listAll();
    String createLanguage(Language language);
    String deleteLanguage(String name);
}
