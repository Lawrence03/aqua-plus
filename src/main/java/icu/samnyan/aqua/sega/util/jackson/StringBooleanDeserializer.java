package icu.samnyan.aqua.sega.util.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class StringBooleanDeserializer extends JsonDeserializer<Integer>{
    @Override
    public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if ("true".equals(p.getText())) {
            return 1;
        } else if ("false".equals(p.getText())) {
            return 0;
        } else {
            return Integer.parseInt(p.getText());
        }
    }
}
