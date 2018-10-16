package com.company.sakila.sakila.sakila.country.generated;

import com.company.sakila.sakila.sakila.country.Country;
import com.company.sakila.sakila.sakila.country.CountryEntityStoreSerializerImpl;
import com.company.sakila.sakila.sakila.country.CountryManager;
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
 * CountryManager}.
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
public final class GeneratedCountryCacheHolder implements EntityStoreHolder<Country> {
    
    private final EntityStore<Country> entityStore;
    private final OfInt fieldCountryIdCache;
    private final OfString fieldCountryCache;
    private final OfComparable<Timestamp> fieldLastUpdateCache;
    
    public GeneratedCountryCacheHolder(
            EntityStore<Country> entityStore,
            OfInt fieldCountryIdCache,
            OfString fieldCountryCache,
            OfComparable<Timestamp> fieldLastUpdateCache) {
        
        this.entityStore          = requireNonNull(entityStore);
        this.fieldCountryIdCache  = requireNonNull(fieldCountryIdCache);
        this.fieldCountryCache    = requireNonNull(fieldCountryCache);
        this.fieldLastUpdateCache = requireNonNull(fieldLastUpdateCache);
    }
    
    @Override
    public EntityStore<Country> getEntityStore() {
        return entityStore;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public <CACHE extends FieldCache<CACHE>> CACHE getFieldCache(ColumnIdentifier<Country> columnId) {
        if (columnId instanceof Country.Identifier) {
            final Country.Identifier _id = (Country.Identifier) columnId;
            switch (_id) {
                case COUNTRY_ID  : return (CACHE) fieldCountryIdCache;
                case COUNTRY     : return (CACHE) fieldCountryCache;
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
                case "country_id"  : return (CACHE) fieldCountryIdCache;
                case "country"     : return (CACHE) fieldCountryCache;
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
    public boolean isHavingMultiFieldCache(ColumnIdentifier<Country> columnId) {
        return false;
    }
    
    public static CompletableFuture<GeneratedCountryCacheHolder> reload(StreamSupplierComponent streamSupplier, ExecutorService executor) {
        return reload(DataStoreHolderUtil.buildEntityStore(
            streamSupplier,
            executor,
            CountryEntityStoreSerializerImpl::new,
            TableIdentifier.of("sakila", "sakila", "country")
        ), executor);
    }
    
    @Override
    public EntityStoreHolder<Country> recycleAndPersist(PersistOperation<Country> persistOperation) {
        return wrapped().recycleAndPersist(persistOperation);
    }
    
    @Override
    public EntityStoreHolder<Country> recycleAndRemove(RemoveOperation<Country> removeOperation) {
        return wrapped().recycleAndRemove(removeOperation);
    }
    
    @Override
    public EntityStoreHolder<Country> recycleAndUpdate(UpdateOperation<Country> updateOperation) {
        return wrapped().recycleAndUpdate(updateOperation);
    }
    
    private EntityStoreHolder<Country> wrapped() {
        // Use explicit type for Stream to improve compilation time.
        final Map<ColumnLabel, FieldCache<?>> fieldCaches = Stream.<Tuple2<HasIdentifier<Country>, FieldCache<?>>>of(
            Tuples.of(Country.COUNTRY_ID, fieldCountryIdCache),
            Tuples.of(Country.COUNTRY,    fieldCountryCache),
            Tuples.of(Country.LAST_UPDATE,fieldLastUpdateCache)
        )
            .collect(toMap(t2 -> t2.get0().identifier().label(), Tuple2::get1));
        final Map<ColumnLabel,  Map<ColumnLabel, MultiFieldCache<?, ?, ?>>>  multiFieldCaches = createMultiCacheMap();
        final Set<ColumnIdentifier<Country>> columnIdentifiers = Stream.<HasIdentifier<Country>>of(
            Country.COUNTRY_ID,
            Country.COUNTRY,
            Country.LAST_UPDATE
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
    
    public static CompletableFuture<GeneratedCountryCacheHolder> reload(CompletableFuture<EntityStore<Country>> entityStoreFuture, ExecutorService executor) {
        final CompletableFuture<FieldCache.OfInt> fieldCountryIdCacheFuture =
            DataStoreHolderUtil.buildIntCache(entityStoreFuture, executor, Country.COUNTRY_ID, FieldCache.DISTINCT);
        
        final CompletableFuture<FieldCache.OfString> fieldCountryCacheFuture =
            DataStoreHolderUtil.buildStringCache(entityStoreFuture, executor, Country.COUNTRY, 0);
        
        final CompletableFuture<FieldCache.OfComparable<Timestamp>> fieldLastUpdateCacheFuture =
            DataStoreHolderUtil.buildComparableCache(entityStoreFuture, executor, Country.LAST_UPDATE, 0);
        
        return entityStoreFuture.thenApplyAsync(entityStore -> {
            try {
                return new GeneratedCountryCacheHolder(
                    entityStore,
                    fieldCountryIdCacheFuture.get(),
                    fieldCountryCacheFuture.get(),
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
        fieldCountryIdCache.close();
        fieldCountryCache.close();
        fieldLastUpdateCache.close();
    }
    
    @Override
    public Map<String, Map<Statistics, ?>> getStatistics() {
        return StatisticsInternalUtil.getStatistics(    
            this,
            entityStore.identifier(),
            Country.Identifier.COUNTRY_ID,
            Country.Identifier.COUNTRY,
            Country.Identifier.LAST_UPDATE
        );
    }
    
    private Map<ColumnLabel, Map<ColumnLabel, MultiFieldCache<?, ?, ?>>> createMultiCacheMap() {
        return Collections.emptyMap();
    }
}