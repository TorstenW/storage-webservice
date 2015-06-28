package net.wmann.cloud.storage.webservice.domain.converter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date> {
	
	@Override
    public Date convertToDatabaseColumn(LocalDateTime date) {
        return date == null ? null : Date.from(Instant.from(date));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date value) {
        return value == null ? null : LocalDateTime.ofInstant(value.toInstant(), ZoneId.systemDefault());
    }

}
