package domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class AddressConverter implements AttributeConverter<Address, String> {
    @Override
    public String convertToDatabaseColumn(Address address) {
        if (address == null) {
            return null;
        }
        return String.format("%s;%s;%s;%s",
                address.getStreet(), address.getCode(), address.getCity(), address.getCountry());
    }

    @Override
    public Address convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        String[] parts = value.split(";");
        return Address.address(parts[0], parts[1], parts[2], parts[3]);
    }
}

