package com.sample.db.postgres.jsonb.data.strategy;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.CustomEntityDirtinessStrategy;
import org.hibernate.Session;
import org.hibernate.persister.entity.EntityPersister;

@Slf4j
public class EntityDirtinessStrategy implements CustomEntityDirtinessStrategy {

    @Override
    public boolean canDirtyCheck(Object entity, EntityPersister persister, Session session) {
        if (entity instanceof DirtyStateIdentifiable) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isDirty(Object entity, EntityPersister persister, Session session) {
        DirtyStateIdentifiable identifiableEntity = (DirtyStateIdentifiable) entity;
        return identifiableEntity.isDirty();
    }

    @Override
    public void resetDirty(Object entity, EntityPersister persister, Session session) {
        if (entity instanceof DirtyStateIdentifiable) {
            ((DirtyStateIdentifiable) entity).setDirty(false);
        }
    }

    @Override
    public void findDirty(Object entity, EntityPersister persister, Session session, DirtyCheckContext dirtyCheckContext) {
        dirtyCheckContext.doDirtyChecking((AttributeInformation attr) -> {
            log.debug(attr.getName());
            return false;
        });
    }
}
