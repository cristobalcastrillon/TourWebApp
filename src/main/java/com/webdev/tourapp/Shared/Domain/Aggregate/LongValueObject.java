package com.webdev.tourapp.Shared.Domain.Aggregate;

import java.util.Objects;

public class LongValueObject {

    protected Long value;

    public Long value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LongValueObject that = (LongValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
