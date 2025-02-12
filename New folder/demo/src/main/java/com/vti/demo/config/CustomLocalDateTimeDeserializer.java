package com.vti.demo.config;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private static final DateTimeFormatter FORMATTER_FULL = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private static final DateTimeFormatter FORMATTER_DATE_ONLY = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public LocalDateTime deserialize(JsonParser arg0, DeserializationContext arg1)
            throws IOException, JacksonException {
        String date = arg0.getText();
        try {
            return LocalDateTime.parse(date, FORMATTER_FULL);
        } catch (DateTimeParseException e) {
            return LocalDate.parse(date, FORMATTER_DATE_ONLY).atStartOfDay();
        }
    }

}
