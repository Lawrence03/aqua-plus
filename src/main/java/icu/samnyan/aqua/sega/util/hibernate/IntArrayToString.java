package icu.samnyan.aqua.sega.util.hibernate;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Converter
public class IntArrayToString implements AttributeConverter<List<Integer>,String> {
    @Override
    public String convertToDatabaseColumn(List<Integer> attribute) {
        return attribute == null ? null : StringUtils.join(attribute,",");
    }

    @Override
    public List<Integer> convertToEntityAttribute(String dbData) {
        if (StringUtils.isBlank(dbData))
            return Collections.emptyList();
        return Arrays.stream(dbData.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
