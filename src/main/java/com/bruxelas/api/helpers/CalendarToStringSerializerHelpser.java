package com.bruxelas.api.helpers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
 
public class CalendarToStringSerializerHelpser extends JsonSerializer<Calendar> {
 
    @Override
    public void serialize(Calendar value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        if (value != null) {        
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String formatted = sdf.format(value.getTime());
            gen.writeString(formatted);
        }
    }
 
}
