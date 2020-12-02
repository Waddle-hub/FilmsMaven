
package hu.uni.eszterhazy.framework.dao.entity.enumandsetHelp;

import javax.persistence.AttributeConverter;

public class SpecialFeaturesConverter implements AttributeConverter<SpecialFeatures, String> {

    @Override
    public String convertToDatabaseColumn(final SpecialFeatures attribute) {
        return attribute.getSpecialFeatures();
    }

    @Override
    public SpecialFeatures convertToEntityAttribute(final String dbData) {
        return SpecialFeatures.fromString(dbData);
    }
}