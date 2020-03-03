package com.sample.db.postgres.jsonb.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    
    private UUID id;
    private String title;
    private Genre genre;
    private String publisher;
    private int star;
    private Author author;
}
