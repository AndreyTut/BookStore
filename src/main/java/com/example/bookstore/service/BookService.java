package com.example.bookstore.service;

import com.example.bookstore.mapper.BookMapper;
import com.example.bookstore.model.Author;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookDto;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository repository;
    private AuthorRepository authorRepository;

    public BookService(BookRepository repository, AuthorRepository authorRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    public List<BookDto> getAll() {
        return repository.findAll().stream()
                .map(BookMapper::BookToBookDto)
                .collect(Collectors.toList());
    }

    public BookDto getById(Long id) {
        return BookMapper.BookToBookDto(
                repository.findById(id).orElseThrow(() -> new RuntimeException("Book doesn't exist, id = " + id))
        );
    }

    public List<BookDto> getByAuthor(Long authorId) {
        return repository.findAllForAuthor(authorId).stream()
                .map(BookMapper::BookToBookDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void create(BookDto bookDto) {
        Author author = authorRepository.findById(bookDto.getAuthorId()).orElseThrow(
                () -> new RuntimeException("Author not found, author id = " + bookDto.getAuthorId())
        );
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setAuthor(author);
        repository.save(book);
    }

    @Transactional
    public void update(BookDto book) {
        Book existing = repository.findById(book.getId()).orElseThrow(
                () -> new RuntimeException("Book not found, id = " + book.getId())
        );
        existing.setName(book.getName());
        Author author = authorRepository.findById(book.getAuthorId()).orElseThrow(
                () -> new RuntimeException("Author not found, author id = " + book.getAuthorId())
        );
        existing.setAuthor(author);
        repository.save(existing);
    }
}
