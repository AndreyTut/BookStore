package com.example.bookstore.controller;

import com.example.bookstore.model.BookDto;
import com.example.bookstore.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService service;
    private int counter = 0;

    public BookController(BookService service) {
        this.service = service;
    }

    @Operation(summary = "Get all books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Books list found",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content)})
    @GetMapping("/book")
    public List<BookDto> findAll() {
        counter++;
        return service.getAll();
    }

    @Operation(summary = "Get all books for the author with given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Author's books found",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content)})
    @GetMapping("/author/{authorId}/book")
    public List<BookDto> getForAuthor(@PathVariable Long authorId) {
        counter++;
        return service.getByAuthor(authorId);
    }

    @Operation(summary = "Get book with given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The book found",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content)})
    @GetMapping("/book/{id}")
    public BookDto getById(@PathVariable Long id) {
        counter++;
        return service.getById(id);
    }

    @Operation(summary = "Create a new book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The book created",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content)})
    @PostMapping("/book")
    public void create(@RequestBody BookDto book) {
        counter++;
        service.create(book);
    }

    @Operation(summary = "Update an existing book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The book updated",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content)})
    @PutMapping("/book")
    public void update(@RequestBody BookDto book) {
        counter++;
        service.update(book);
    }

    @Operation(summary = "Delete a book by it's id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The book deleted",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content)})
    @DeleteMapping("/book/{id}")
    public void delete(@PathVariable Long id) {
        counter++;
        service.delete(id);
    }

    @GetMapping("/book/counter")
    public int getCounter() {
        return counter;
    }
}
