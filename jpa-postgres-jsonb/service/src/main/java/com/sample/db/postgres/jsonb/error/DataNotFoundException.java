package com.sample.db.postgres.jsonb.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString(callSuper = true)
@Getter
@Setter
public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String string) {
        super(string);
    }
    
}
