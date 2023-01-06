package com.example.bookstore.service;

import com.example.bookstore.mapper.AuthorMapper;
import com.example.bookstore.model.Author;
import com.example.bookstore.model.AuthorDto;
import com.example.bookstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<AuthorDto> getAll() {
        return repository.findAll().stream()
                .map(AuthorMapper::AuthorToAuthorDto)
                .collect(Collectors.toList());
    }

    public AuthorDto getById(Long id) {
        return AuthorMapper.AuthorToAuthorDto(repository.findByIdWithBooks(id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void save(Author author) {
        repository.save(author);
    }
}
