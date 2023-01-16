package com.example.bookstore.repository;

import com.example.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(
            "select a from Author a " +
                    "  left join fetch Book b" +
                    "  where a.id = :id"
    )
    Author findByIdWithBooks(@RequestParam Long id);
}
