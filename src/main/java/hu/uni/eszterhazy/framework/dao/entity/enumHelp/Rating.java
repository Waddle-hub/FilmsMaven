package hu.uni.eszterhazy.framework.dao.entity.enumHelp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum Rating {

    G("G"),
    PG("PG"),
    PG13("PG-13"),
    R("R"),
    NC17("NC-17");

    private static final Map<String, Rating> Mapping = Arrays.stream(values())
            .collect(Collectors.toMap(Rating::getRating, Function.identity()));

    private final String rating;


    public static Rating fromString(final String rating) {
        return Mapping.get(rating);
    }
}
