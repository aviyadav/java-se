package com.sample.db.postgres.jsonb.util;

import java.util.UUID;
import org.dozer.BeanFactory;

public class UuidBeanFactory implements BeanFactory {

    @Override
    public Object createBean(Object source, Class<?> sourceClass, String targetBeanId) {
        if (source == null) {
            return null;
        }

        UUID uuidSrc = (UUID) source;
        UUID uuidDest = new UUID(uuidSrc.getMostSignificantBits(), uuidSrc.getLeastSignificantBits());
        return uuidDest;
    }

}
