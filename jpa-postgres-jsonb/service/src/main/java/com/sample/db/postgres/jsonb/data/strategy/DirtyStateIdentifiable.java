package com.sample.db.postgres.jsonb.data.strategy;

public interface DirtyStateIdentifiable {
    
    boolean isDirty();
    void setDirty(boolean dirty);
}
