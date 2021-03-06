package com.sample.db.postgres.jsonb.data.repository;

import com.sample.db.postgres.jsonb.data.entity.BookEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {

    @Query("SELECT DISTINCT b.publisher FROM BookEntity b WHERE UPPER(b.publisher) LIKE UPPER(CONCAT('%', ?1, '%'))")
    List<String> findDistinctPublisher(String publisher);

    @Query(value = "SELECT * FROM example_jsonb.books b WHERE b.author->>'firstName' ILIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    List<BookEntity> findByAuthorFirstName(String firstName);

    @Query(value = "SELECT * FROM example_jsonb.books b WHERE b.author->>'lastName' ILIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    List<BookEntity> findByAuthorLastName(String lastName);

    @Query(value = "SELECT * FROM example_jsonb.books b WHERE b.author->>'firstName' ILIKE CONCAT('%', ?1, '%') AND  b.author->>'lastName' ILIKE CONCAT('%', ?2, '%')", nativeQuery = true)
    List<BookEntity> findByAuthorFirstNameAndLastName(String firstName, String lastName);
}
