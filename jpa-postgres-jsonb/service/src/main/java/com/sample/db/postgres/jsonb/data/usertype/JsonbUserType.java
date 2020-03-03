package com.sample.db.postgres.jsonb.data.usertype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;

public class JsonbUserType implements UserType, ParameterizedType {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private Class<?> clazz;

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.JAVA_OBJECT};
    }

    @Override
    public Class returnedClass() {
        return clazz;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return x.equals(y);
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return o.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        String json = rs.getString(names[0]);
        if (json != null) {
            try {
                return MAPPER.readValue(json.getBytes("UTF-8"), returnedClass());
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(JsonbUserType.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(JsonbUserType.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.OTHER);
        } else {
            try {
                final StringWriter writer = new StringWriter();
                MAPPER.writeValue(writer, value);
                writer.flush();
                st.setObject(index, writer.toString(), Types.OTHER);
            } catch (IOException ex) {
                Logger.getLogger(JsonbUserType.class.getName()).log(Level.SEVERE, "Failed to convert " + returnedClass() + " to String " + ex.getMessage(), ex);
            }
            }
        }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        if(value != null) {
            try {
                return MAPPER.readValue(MAPPER.writeValueAsString(value), returnedClass());
            } catch (JsonProcessingException ex) {
                Logger.getLogger(JsonbUserType.class.getName()).log(Level.SEVERE, null, ex);
                throw new HibernateException("Failed to deep copy object", ex);
            }
        }
        return null;
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        try {
            return MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(JsonbUserType.class.getName()).log(Level.SEVERE, null, ex);
            throw new HibernateException("Failed to disassemble object", ex);
        }
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return deepCopy(cached);
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return deepCopy(original);
    }

    @Override
    public void setParameterValues(Properties params) {
        try {
            String className = params.getProperty("className");

            clazz = Class.forName(className);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JsonbUserType.class.getName()).log(Level.SEVERE, null, ex);
            throw new HibernateException("className not found", ex);
        }
    }

}
