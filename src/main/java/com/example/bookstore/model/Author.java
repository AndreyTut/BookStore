package com.example.bookstore.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_id_seq"
    )
    @SequenceGenerator(
            name = "author_id_seq",
            allocationSize = 1,
            initialValue = 1000
    )
    private Long id;
    private String name;
    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Book> books;

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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
