package com.example.bookstore.repository;

import com.example.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(
            "select b from Book b " +
                    "  where b.author.id = :authorId"
    )
    List<Book> findAllForAuthor(@RequestParam Long authorId);
}
