package com.company.sakila.sakila.sakila.nicer_but_slower_film_list.generated;

import com.company.sakila.sakila.sakila.nicer_but_slower_film_list.NicerButSlowerFilmList;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.manager.Manager;
import com.speedment.runtime.field.Field;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * The generated base interface for the manager of every {@link
 * com.company.sakila.sakila.sakila.nicer_but_slower_film_list.NicerButSlowerFilmList}
 * entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedNicerButSlowerFilmListManager extends Manager<NicerButSlowerFilmList> {
    
    TableIdentifier<NicerButSlowerFilmList> IDENTIFIER = TableIdentifier.of("sakila", "sakila", "nicer_but_slower_film_list");
    List<Field<NicerButSlowerFilmList>> FIELDS = unmodifiableList(asList(
        NicerButSlowerFilmList.FID,
        NicerButSlowerFilmList.TITLE,
        NicerButSlowerFilmList.DESCRIPTION,
        NicerButSlowerFilmList.CATEGORY,
        NicerButSlowerFilmList.PRICE,
        NicerButSlowerFilmList.LENGTH,
        NicerButSlowerFilmList.RATING,
        NicerButSlowerFilmList.ACTORS
    ));
    
    @Override
    default Class<NicerButSlowerFilmList> getEntityClass() {
        return NicerButSlowerFilmList.class;
    }
}