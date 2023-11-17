package domain;

import org.springframework.dao.DataIntegrityViolationException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class NameConverter implements AttributeConverter<Name, String> {
    @Override
    public String convertToDatabaseColumn(Name name) {
        if (name == null || name.getFirstName() == null || name.getLastName() == null) {
            throw new DataIntegrityViolationException("NAME must include both first and last names");
        }
        return name.getFirstName() + ";" + name.getLastName();
    }

    @Override
    public Name convertToEntityAttribute(String value) {
        String[] parts = value.split(";");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            throw new DataIntegrityViolationException("Invalid format for FULL_NAME");
        }
        return Name.name(parts[0], parts[1]);
    }
}
