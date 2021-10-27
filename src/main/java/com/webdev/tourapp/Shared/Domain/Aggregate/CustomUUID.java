package com.webdev.tourapp.Shared.Domain.Aggregate;

import com.webdev.tourapp.Shared.Domain.Exceptions.UUIDNotValid;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class CustomUUID implements Serializable {

    private String value;

    public CustomUUID(String value) {
        //this.validate(value);
        this.value = value;
    }

    protected CustomUUID() {}

    private void validate(String value) {
        this.validateUUIDFormatRule(value);
    }

    public String value() {
        return value;
    }

    private void validateUUIDFormatRule(String value)
    {
        //TODO: Construir Regex para evaluar el UUID autogenerado que se pasa como 'value'
        try {
            UUID.fromString(value);
        }
        catch (Exception ex)
        {
            throw new UUIDNotValid("The UUID is not formatted correctly.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomUUID that = (CustomUUID) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}