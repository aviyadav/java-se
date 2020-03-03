package com.sample.db.postgres.jsonb.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Genre {
    
    DRAMA, ROMANCE, GUIDE, TRAVEL;
    
    @JsonCreator
    public static Genre fromValues(String value) {
        return valueOf(value.toUpperCase());
    }
    
    public static String toValue(Genre genre) {
        return genre.name().toLowerCase();
    }
}
