package org.crx.markets.rest.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public abstract class AbstractRESTService {
    
    private static final ObjectMapper JSON_MAPPER_EXTERNAL = buildExternalJsonObjectMapper();

    private static ObjectMapper buildExternalJsonObjectMapper() {
        final ObjectMapper jsonMapper = new ObjectMapper();

        jsonMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        jsonMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        jsonMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        jsonMapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.PUBLIC_ONLY);

        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", new Locale("en"));
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        jsonMapper.setDateFormat(dateFormat);

        return jsonMapper;
    }

    protected String toJson(final Serializable obj) throws JsonProcessingException {
        if (obj == null) {
            return null;
        }
        return JSON_MAPPER_EXTERNAL.writeValueAsString(obj);
    }
}
