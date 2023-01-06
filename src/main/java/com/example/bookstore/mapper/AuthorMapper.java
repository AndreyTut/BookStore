package com.example.bookstore.mapper;

import com.example.bookstore.model.Author;
import com.example.bookstore.model.AuthorDto;

import java.util.stream.Collectors;

public class AuthorMapper {

    public static AuthorDto AuthorToAuthorDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setName(author.getName());
        authorDto.setId(author.getId());
        authorDto.setBooks(author.getBooks().stream()
                .map(BookMapper::BookToBookDto)
                .collect(Collectors.toList()));
        return authorDto;
    }
}
