package com.webdev.tourapp.Shared.Domain.Aggregate;

import java.util.Date;
import java.util.Objects;

public class DateValueObject {

    protected Date value;

    public DateValueObject(Date value) {
        this.value = value;
    }

    public Date value() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateValueObject that = (DateValueObject) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
