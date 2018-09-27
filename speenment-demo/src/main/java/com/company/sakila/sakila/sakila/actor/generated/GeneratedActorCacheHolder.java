package com.company.sakila.sakila.sakila.actor.generated;

import com.company.sakila.sakila.sakila.actor.Actor;
import com.company.sakila.sakila.sakila.actor.ActorEntityStoreSerializerImpl;
import com.company.sakila.sakila.sakila.actor.ActorManager;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;
import com.speedment.enterprise.datastore.runtime.HasStatistics.Statistics;
import com.speedment.enterprise.datastore.runtime.entitystore.EntityStore;
import com.speedment.enterprise.datastore.runtime.entitystore.EntityStoreHolder;
import com.speedment.enterprise.datastore.runtime.fieldcache.FieldCache.OfComparable;
import com.speedment.enterprise.datastore.runtime.fieldcache.FieldCache.OfInt;
import com.speedment.enterprise.datastore.runtime.fieldcache.FieldCache.OfString;
import com.speedment.enterprise.datastore.runtime.fieldcache.FieldCache;
import com.speedment.enterprise.datastore.runtime.fieldcache.MultiFieldCache;
import com.speedment.enterprise.datastore.runtime.internal.util.StatisticsInternalUtil;
import com.speedment.enterprise.datastore.runtime.util.DataStoreHolderUtil;
import com.speedment.runtime.bulk.PersistOperation;
import com.speedment.runtime.bulk.RemoveOperation;
import com.speedment.runtime.bulk.UpdateOperation;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.config.identifier.ColumnLabel;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.component.StreamSupplierComponent;
import com.speedment.runtime.field.Field;
import com.speedment.runtime.field.trait.HasIdentifier;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/**
 * A holder class for the various caches that are used to speed up the {@link
 * ActorManager}.
 * 
 * Generated by
 * com.speedment.enterprise.datastore.generator.internal.code.GeneratedEntityCacheHolderTranslator
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public final class GeneratedActorCacheHolder implements EntityStoreHolder<Actor> {
    
    private final EntityStore<Actor> entityStore;
    private final OfInt fieldActorIdCache;
    private final OfString fieldFirstNameCache;
    private final OfString fieldLastNameCache;
    private final OfComparable<Timestamp> fieldLastUpdateCache;
    
    public GeneratedActorCacheHolder(
            EntityStore<Actor> entityStore,
            OfInt fieldActorIdCache,
            OfString fieldFirstNameCache,
            OfString fieldLastNameCache,
            OfComparable<Timestamp> fieldLastUpdateCache) {
        
        this.entityStore          = requireNonNull(entityStore);
        this.fieldActorIdCache    = requireNonNull(fieldActorIdCache);
        this.fieldFirstNameCache  = requireNonNull(fieldFirstNameCache);
        this.fieldLastNameCache   = requireNonNull(fieldLastNameCache);
        this.fieldLastUpdateCache = requireNonNull(fieldLastUpdateCache);
    }
    
    @Override
    public EntityStore<Actor> getEntityStore() {
        return entityStore;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public <CACHE extends FieldCache<CACHE>> CACHE getFieldCache(ColumnIdentifier<Actor> columnId) {
        if (columnId instanceof Actor.Identifier) {
            final Actor.Identifier _id = (Actor.Identifier) columnId;
            switch (_id) {
                case ACTOR_ID    : return (CACHE) fieldActorIdCache;
                case FIRST_NAME  : return (CACHE) fieldFirstNameCache;
                case LAST_NAME   : return (CACHE) fieldLastNameCache;
                case LAST_UPDATE : return (CACHE) fieldLastUpdateCache;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = columnId.getColumnId();
            switch (_colName) {
                case "actor_id"    : return (CACHE) fieldActorIdCache;
                case "first_name"  : return (CACHE) fieldFirstNameCache;
                case "last_name"   : return (CACHE) fieldLastNameCache;
                case "last_update" : return (CACHE) fieldLastUpdateCache;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public boolean isHavingMultiFieldCache(ColumnIdentifier<Actor> columnId) {
        return false;
    }
    
    public static CompletableFuture<GeneratedActorCacheHolder> reload(StreamSupplierComponent streamSupplier, ExecutorService executor) {
        return reload(DataStoreHolderUtil.buildEntityStore(
            streamSupplier,
            executor,
            ActorEntityStoreSerializerImpl::new,
            TableIdentifier.of("sakila", "sakila", "actor")
        ), executor);
    }
    
    @Override
    public EntityStoreHolder<Actor> recycleAndPersist(PersistOperation<Actor> persistOperation) {
        return wrapped().recycleAndPersist(persistOperation);
    }
    
    @Override
    public EntityStoreHolder<Actor> recycleAndRemove(RemoveOperation<Actor> removeOperation) {
        return wrapped().recycleAndRemove(removeOperation);
    }
    
    @Override
    public EntityStoreHolder<Actor> recycleAndUpdate(UpdateOperation<Actor> updateOperation) {
        return wrapped().recycleAndUpdate(updateOperation);
    }
    
    private EntityStoreHolder<Actor> wrapped() {
        // Use explicit type for Stream to improve compilation time.
        final Map<ColumnLabel, FieldCache<?>> fieldCaches = Stream.<Tuple2<HasIdentifier<Actor>, FieldCache<?>>>of(
            Tuples.of(Actor.ACTOR_ID,   fieldActorIdCache),
            Tuples.of(Actor.FIRST_NAME, fieldFirstNameCache),
            Tuples.of(Actor.LAST_NAME,  fieldLastNameCache),
            Tuples.of(Actor.LAST_UPDATE,fieldLastUpdateCache)
        )
            .collect(toMap(t2 -> t2.get0().identifier().label(), Tuple2::get1));
        final Map<ColumnLabel,  Map<ColumnLabel, MultiFieldCache<?, ?, ?>>>  multiFieldCaches = createMultiCacheMap();
        final Set<ColumnIdentifier<Actor>> columnIdentifiers = Stream.<HasIdentifier<Actor>>of(
            Actor.ACTOR_ID,
            Actor.FIRST_NAME,
            Actor.LAST_NAME,
            Actor.LAST_UPDATE
        )
            .map(HasIdentifier::identifier)
            .collect(toSet());
        return EntityStoreHolder.of(
            entityStore,
            fieldCaches,
            multiFieldCaches,
            columnIdentifiers
        );
    }
    
    public static CompletableFuture<GeneratedActorCacheHolder> reload(CompletableFuture<EntityStore<Actor>> entityStoreFuture, ExecutorService executor) {
        final CompletableFuture<FieldCache.OfInt> fieldActorIdCacheFuture =
            DataStoreHolderUtil.buildIntCache(entityStoreFuture, executor, Actor.ACTOR_ID, FieldCache.DISTINCT);
        
        final CompletableFuture<FieldCache.OfString> fieldFirstNameCacheFuture =
            DataStoreHolderUtil.buildStringCache(entityStoreFuture, executor, Actor.FIRST_NAME, 0);
        
        final CompletableFuture<FieldCache.OfString> fieldLastNameCacheFuture =
            DataStoreHolderUtil.buildStringCache(entityStoreFuture, executor, Actor.LAST_NAME, 0);
        
        final CompletableFuture<FieldCache.OfComparable<Timestamp>> fieldLastUpdateCacheFuture =
            DataStoreHolderUtil.buildComparableCache(entityStoreFuture, executor, Actor.LAST_UPDATE, 0);
        
        return entityStoreFuture.thenApplyAsync(entityStore -> {
            try {
                return new GeneratedActorCacheHolder(
                    entityStore,
                    fieldActorIdCacheFuture.get(),
                    fieldFirstNameCacheFuture.get(),
                    fieldLastNameCacheFuture.get(),
                    fieldLastUpdateCacheFuture.get()
                );
            } catch (final ExecutionException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    
    @Override
    public void close() {
        entityStore.close();
        fieldActorIdCache.close();
        fieldFirstNameCache.close();
        fieldLastNameCache.close();
        fieldLastUpdateCache.close();
    }
    
    @Override
    public Map<String, Map<Statistics, ?>> getStatistics() {
        return StatisticsInternalUtil.getStatistics(    
            this,
            entityStore.identifier(),
            Actor.Identifier.ACTOR_ID,
            Actor.Identifier.FIRST_NAME,
            Actor.Identifier.LAST_NAME,
            Actor.Identifier.LAST_UPDATE
        );
    }
    
    private Map<ColumnLabel, Map<ColumnLabel, MultiFieldCache<?, ?, ?>>> createMultiCacheMap() {
        return Collections.emptyMap();
    }
}