package icu.samnyan.aqua.sega.util.hibernate;

import icu.samnyan.aqua.sega.mai2.model.request.data.MapEncountNpc;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Converter
public class EncountMapNpcListConverter implements AttributeConverter<List<MapEncountNpc>, String> {
    @Override
    public String convertToDatabaseColumn(List<MapEncountNpc> attribute) {
        if(attribute == null || attribute.isEmpty()) return null;
        StringBuilder sb = new StringBuilder();
        for(MapEncountNpc n : attribute) {
            sb.append(n.getNpcId()).append(":").append(n.getMusicId()).append(",");
        }
        if(sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public List<MapEncountNpc> convertToEntityAttribute(String dbData) {
        if(StringUtils.isBlank(dbData)) return Collections.emptyList();
        List<MapEncountNpc> result = new LinkedList<>();
        String[] values = dbData.split(",");
        for(String value : values) {
            String[] v = value.split(":");
            result.add(new MapEncountNpc(Integer.parseInt(v[0]), Integer.parseInt(v[1])));
        }
        return result;
    }
}
