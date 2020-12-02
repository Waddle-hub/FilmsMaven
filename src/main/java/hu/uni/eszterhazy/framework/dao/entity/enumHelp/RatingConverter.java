package hu.uni.eszterhazy.framework.dao.entity.enumHelp;

import javax.persistence.AttributeConverter;

public class RatingConverter implements AttributeConverter<Rating, String> {

    @Override
    public String convertToDatabaseColumn(final Rating attribute) {
        return attribute.getRating();
    }

    @Override
    public Rating convertToEntityAttribute(final String dbData) {
        return Rating.fromString(dbData);
    }
}