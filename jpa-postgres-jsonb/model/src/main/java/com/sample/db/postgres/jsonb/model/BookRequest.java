package com.sample.db.postgres.jsonb.model;

import lombok.Data;

@Data
public class BookRequest {
    
    private String title;
    private Genre genre;
    private String publisher;
    private int star;
    private Author author;
}
