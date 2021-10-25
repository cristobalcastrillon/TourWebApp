package com.webdev.tourapp.Tours.TourInstance.Infrastructure.Hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.StartingLocation;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class StartingLocationCustomType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[] {Types.LONGNVARCHAR};
    }

    @Override
    public Class returnedClass() {
        return StartingLocation.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return Objects.hashCode(x);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        StartingLocation response = null;
        try {
            Optional<String> value = Optional.ofNullable(rs.getString(names[0]));
            if(value.isPresent()) {
                HashMap<String, Object> mapper = new ObjectMapper().readValue(value.get(), HashMap.class);
                response = new StartingLocation((String) mapper.get("locationID"), (String) mapper.get("locationName"),
                        (String) mapper.get("locationCoordinates"), (String) mapper.get("locationDescription"),
                        (String) mapper.get("locationCategory"), (Optional<String>) mapper.get("locationWebsiteURL"),
                        (Optional<Double>) mapper.get("locationPrice"));
            }
        }
        catch (Exception e) {
            throw new HibernateException("Error leyendo mapa de StartingLocation " + e.toString());
        }
        return Optional.ofNullable(response);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        Optional<StartingLocation> object = (value == null) ? Optional.empty() : Optional.of((StartingLocation) value);
        try {
            if(object.isEmpty()) {
                st.setNull(index, Types.VARCHAR);
            }
            else {
                ObjectMapper mapper = new ObjectMapper();
                //TODO: Fix this: Optional<Double> (locationPrice) when mapped onto the serialized object, does not return its value, but the value of isPresent or isEmty
                String serializedObject = mapper.writeValueAsString(object.get().dataDB());
                st.setString(index, serializedObject);
            }
        }
        catch (Exception e) {
            throw new HibernateException("Error serializando el valor de StartingLocation " + e.toString());
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return null;
    }
}
