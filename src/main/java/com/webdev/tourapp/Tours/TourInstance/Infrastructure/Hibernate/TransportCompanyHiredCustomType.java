package com.webdev.tourapp.Tours.TourInstance.Infrastructure.Hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webdev.tourapp.Tours.TourInstance.Domain.Entities.TransportCompanyHired;
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

public class TransportCompanyHiredCustomType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[] {Types.LONGNVARCHAR};
    }

    @Override
    public Class returnedClass() {
        return TransportCompanyHired.class;
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
        TransportCompanyHired response = null;
        try {
            Optional<String> value = Optional.ofNullable(rs.getString(names[0]));
            if(value.isPresent()) {
                HashMap<String, Object> mapper = new ObjectMapper().readValue(value.get(), HashMap.class);
                response = new TransportCompanyHired((String) mapper.get("companyID"), (String) mapper.get("companyName"),
                        (String) mapper.get("companyPhoneNumber"), (Optional<String>) mapper.get("companyURL"),
                        (Double) mapper.get("companyBaseFare"));
                //TODO: mapper Optional
            }
        }
        catch (Exception e) {
            throw new HibernateException("Error leyendo mapa de compañía de transporte contratada " + e.toString());
        }
        return Optional.ofNullable(response);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        Optional<TransportCompanyHired> object = (value == null) ? Optional.empty() : (Optional<TransportCompanyHired>) value;
        try {
            if(object.isEmpty()) {
                st.setNull(index, Types.VARCHAR);
            }
            else {
                ObjectMapper mapper = new ObjectMapper();
                String serializedObject = mapper.writeValueAsString(object.get().dataDB());
                st.setString(index, serializedObject);
            }
        }
        catch (Exception e) {
            throw new HibernateException("Error serializando el valor de TransportCompanyHired " + e.toString());
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
