package com.example.bookstore.mapper;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookDto;

public class BookMapper {

    public static BookDto BookToBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setAuthorId(book.getAuthor().getId());
        bookDto.setAuthorName(book.getAuthor().getName());
        return bookDto;
    }
}
