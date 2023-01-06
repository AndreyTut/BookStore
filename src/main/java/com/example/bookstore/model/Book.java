package com.example.bookstore.model;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_id_seq"
    )
    @SequenceGenerator(
            name = "book_id_seq",
            allocationSize = 1,
            initialValue = 1000
    )
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
