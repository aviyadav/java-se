package com.company.sakila.sakila.sakila.actor_info.generated;

import com.company.sakila.sakila.sakila.actor_info.ActorInfo;
import com.company.sakila.sakila.sakila.actor_info.ActorInfoManager;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.manager.AbstractViewManager;
import com.speedment.runtime.field.Field;

import java.util.stream.Stream;

/**
 * The generated base implementation for the manager of every {@link
 * com.company.sakila.sakila.sakila.actor_info.ActorInfo} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedActorInfoManagerImpl 
extends AbstractViewManager<ActorInfo> 
implements GeneratedActorInfoManager {
    
    private final TableIdentifier<ActorInfo> tableIdentifier;
    
    protected GeneratedActorInfoManagerImpl() {
        this.tableIdentifier = TableIdentifier.of("sakila", "sakila", "actor_info");
    }
    
    @Override
    public TableIdentifier<ActorInfo> getTableIdentifier() {
        return tableIdentifier;
    }
    
    @Override
    public Stream<Field<ActorInfo>> fields() {
        return ActorInfoManager.FIELDS.stream();
    }
    
    @Override
    public Stream<Field<ActorInfo>> primaryKeyFields() {
        return Stream.empty();
    }
}