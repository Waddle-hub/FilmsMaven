package hu.uni.eszterhazy.framework.dao.entity.enumandsetHelp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum SpecialFeatures {

    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETEDSCENES("Deleted Scenes"),
    BEHINDTHESCENES("Behind the Scenes");

    private static final Map<String, SpecialFeatures> Mapping = Arrays.stream(values())
            .collect(Collectors.toMap(SpecialFeatures::getSpecialFeatures, Function.identity()));

    private final String specialFeatures;


    public static SpecialFeatures fromString(final String specialFeatures) {
        return Mapping.get(specialFeatures);
    }

    @Override
    public String toString() {
        switch(this){
            case TRAILERS: return "Trailers";
            case COMMENTARIES: return "Commentaries";
            case DELETEDSCENES: return "Deleted Scenes";
            case BEHINDTHESCENES: return "Behind the Scenes";
            default: throw new IllegalArgumentException();
        }
    }
}
