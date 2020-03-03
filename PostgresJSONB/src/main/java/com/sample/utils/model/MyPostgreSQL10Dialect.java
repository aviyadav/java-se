package com.sample.utils.model;

import java.sql.Types;
import org.hibernate.dialect.PostgreSQL10Dialect;

public class MyPostgreSQL10Dialect extends PostgreSQL10Dialect {

    public MyPostgreSQL10Dialect() {
        this.registerColumnType(Types.JAVA_OBJECT, "jsonb");
    }
}
