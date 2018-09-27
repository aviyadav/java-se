package com.company.sakila.sakila.sakila.address.generated;

import com.company.sakila.sakila.sakila.address.Address;
import com.company.sakila.sakila.sakila.address.AddressEntityStoreSerializerImpl;
import com.company.sakila.sakila.sakila.address.AddressManager;
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
 * AddressManager}.
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
public final class GeneratedAddressCacheHolder implements EntityStoreHolder<Address> {
    
    private final EntityStore<Address> entityStore;
    private final OfInt fieldAddressIdCache;
    private final OfString fieldAddressCache;
    private final OfString fieldAddress2Cache;
    private final OfString fieldDistrictCache;
    private final OfInt fieldCityIdCache;
    private final OfString fieldPostalCodeCache;
    private final OfString fieldPhoneCache;
    private final OfComparable<Timestamp> fieldLastUpdateCache;
    
    public GeneratedAddressCacheHolder(
            EntityStore<Address> entityStore,
            OfInt fieldAddressIdCache,
            OfString fieldAddressCache,
            OfString fieldAddress2Cache,
            OfString fieldDistrictCache,
            OfInt fieldCityIdCache,
            OfString fieldPostalCodeCache,
            OfString fieldPhoneCache,
            OfComparable<Timestamp> fieldLastUpdateCache) {
        
        this.entityStore          = requireNonNull(entityStore);
        this.fieldAddressIdCache  = requireNonNull(fieldAddressIdCache);
        this.fieldAddressCache    = requireNonNull(fieldAddressCache);
        this.fieldAddress2Cache   = requireNonNull(fieldAddress2Cache);
        this.fieldDistrictCache   = requireNonNull(fieldDistrictCache);
        this.fieldCityIdCache     = requireNonNull(fieldCityIdCache);
        this.fieldPostalCodeCache = requireNonNull(fieldPostalCodeCache);
        this.fieldPhoneCache      = requireNonNull(fieldPhoneCache);
        this.fieldLastUpdateCache = requireNonNull(fieldLastUpdateCache);
    }
    
    @Override
    public EntityStore<Address> getEntityStore() {
        return entityStore;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public <CACHE extends FieldCache<CACHE>> CACHE getFieldCache(ColumnIdentifier<Address> columnId) {
        if (columnId instanceof Address.Identifier) {
            final Address.Identifier _id = (Address.Identifier) columnId;
            switch (_id) {
                case ADDRESS_ID  : return (CACHE) fieldAddressIdCache;
                case ADDRESS     : return (CACHE) fieldAddressCache;
                case ADDRESS2    : return (CACHE) fieldAddress2Cache;
                case DISTRICT    : return (CACHE) fieldDistrictCache;
                case CITY_ID     : return (CACHE) fieldCityIdCache;
                case POSTAL_CODE : return (CACHE) fieldPostalCodeCache;
                case PHONE       : return (CACHE) fieldPhoneCache;
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
                case "address_id"  : return (CACHE) fieldAddressIdCache;
                case "address"     : return (CACHE) fieldAddressCache;
                case "address2"    : return (CACHE) fieldAddress2Cache;
                case "district"    : return (CACHE) fieldDistrictCache;
                case "city_id"     : return (CACHE) fieldCityIdCache;
                case "postal_code" : return (CACHE) fieldPostalCodeCache;
                case "phone"       : return (CACHE) fieldPhoneCache;
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
    public boolean isHavingMultiFieldCache(ColumnIdentifier<Address> columnId) {
        return false;
    }
    
    public static CompletableFuture<GeneratedAddressCacheHolder> reload(StreamSupplierComponent streamSupplier, ExecutorService executor) {
        return reload(DataStoreHolderUtil.buildEntityStore(
            streamSupplier,
            executor,
            AddressEntityStoreSerializerImpl::new,
            TableIdentifier.of("sakila", "sakila", "address")
        ), executor);
    }
    
    @Override
    public EntityStoreHolder<Address> recycleAndPersist(PersistOperation<Address> persistOperation) {
        return wrapped().recycleAndPersist(persistOperation);
    }
    
    @Override
    public EntityStoreHolder<Address> recycleAndRemove(RemoveOperation<Address> removeOperation) {
        return wrapped().recycleAndRemove(removeOperation);
    }
    
    @Override
    public EntityStoreHolder<Address> recycleAndUpdate(UpdateOperation<Address> updateOperation) {
        return wrapped().recycleAndUpdate(updateOperation);
    }
    
    private EntityStoreHolder<Address> wrapped() {
        // Use explicit type for Stream to improve compilation time.
        final Map<ColumnLabel, FieldCache<?>> fieldCaches = Stream.<Tuple2<HasIdentifier<Address>, FieldCache<?>>>of(
            Tuples.of(Address.ADDRESS_ID, fieldAddressIdCache),
            Tuples.of(Address.ADDRESS,    fieldAddressCache),
            Tuples.of(Address.ADDRESS2,   fieldAddress2Cache),
            Tuples.of(Address.DISTRICT,   fieldDistrictCache),
            Tuples.of(Address.CITY_ID,    fieldCityIdCache),
            Tuples.of(Address.POSTAL_CODE,fieldPostalCodeCache),
            Tuples.of(Address.PHONE,      fieldPhoneCache),
            Tuples.of(Address.LAST_UPDATE,fieldLastUpdateCache)
        )
            .collect(toMap(t2 -> t2.get0().identifier().label(), Tuple2::get1));
        final Map<ColumnLabel,  Map<ColumnLabel, MultiFieldCache<?, ?, ?>>>  multiFieldCaches = createMultiCacheMap();
        final Set<ColumnIdentifier<Address>> columnIdentifiers = Stream.<HasIdentifier<Address>>of(
            Address.ADDRESS_ID,
            Address.ADDRESS,
            Address.ADDRESS2,
            Address.DISTRICT,
            Address.CITY_ID,
            Address.POSTAL_CODE,
            Address.PHONE,
            Address.LAST_UPDATE
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
    
    public static CompletableFuture<GeneratedAddressCacheHolder> reload(CompletableFuture<EntityStore<Address>> entityStoreFuture, ExecutorService executor) {
        final CompletableFuture<FieldCache.OfInt> fieldAddressIdCacheFuture =
            DataStoreHolderUtil.buildIntCache(entityStoreFuture, executor, Address.ADDRESS_ID, FieldCache.DISTINCT);
        
        final CompletableFuture<FieldCache.OfString> fieldAddressCacheFuture =
            DataStoreHolderUtil.buildStringCache(entityStoreFuture, executor, Address.ADDRESS, 0);
        
        final CompletableFuture<FieldCache.OfString> fieldAddress2CacheFuture =
            DataStoreHolderUtil.buildStringCache(entityStoreFuture, executor, Address.ADDRESS2, 0);
        
        final CompletableFuture<FieldCache.OfString> fieldDistrictCacheFuture =
            DataStoreHolderUtil.buildStringCache(entityStoreFuture, executor, Address.DISTRICT, 0);
        
        final CompletableFuture<FieldCache.OfInt> fieldCityIdCacheFuture =
            DataStoreHolderUtil.buildIntCache(entityStoreFuture, executor, Address.CITY_ID, 0);
        
        final CompletableFuture<FieldCache.OfString> fieldPostalCodeCacheFuture =
            DataStoreHolderUtil.buildStringCache(entityStoreFuture, executor, Address.POSTAL_CODE, 0);
        
        final CompletableFuture<FieldCache.OfString> fieldPhoneCacheFuture =
            DataStoreHolderUtil.buildStringCache(entityStoreFuture, executor, Address.PHONE, 0);
        
        final CompletableFuture<FieldCache.OfComparable<Timestamp>> fieldLastUpdateCacheFuture =
            DataStoreHolderUtil.buildComparableCache(entityStoreFuture, executor, Address.LAST_UPDATE, 0);
        
        return entityStoreFuture.thenApplyAsync(entityStore -> {
            try {
                return new GeneratedAddressCacheHolder(
                    entityStore,
                    fieldAddressIdCacheFuture.get(),
                    fieldAddressCacheFuture.get(),
                    fieldAddress2CacheFuture.get(),
                    fieldDistrictCacheFuture.get(),
                    fieldCityIdCacheFuture.get(),
                    fieldPostalCodeCacheFuture.get(),
                    fieldPhoneCacheFuture.get(),
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
        fieldAddressIdCache.close();
        fieldAddressCache.close();
        fieldAddress2Cache.close();
        fieldDistrictCache.close();
        fieldCityIdCache.close();
        fieldPostalCodeCache.close();
        fieldPhoneCache.close();
        fieldLastUpdateCache.close();
    }
    
    @Override
    public Map<String, Map<Statistics, ?>> getStatistics() {
        return StatisticsInternalUtil.getStatistics(    
            this,
            entityStore.identifier(),
            Address.Identifier.ADDRESS_ID,
            Address.Identifier.ADDRESS,
            Address.Identifier.ADDRESS2,
            Address.Identifier.DISTRICT,
            Address.Identifier.CITY_ID,
            Address.Identifier.POSTAL_CODE,
            Address.Identifier.PHONE,
            Address.Identifier.LAST_UPDATE
        );
    }
    
    private Map<ColumnLabel, Map<ColumnLabel, MultiFieldCache<?, ?, ?>>> createMultiCacheMap() {
        return Collections.emptyMap();
    }
}