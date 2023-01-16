package com.example.bookstore.controller;

import com.example.bookstore.model.Author;
import com.example.bookstore.model.AuthorDto;
import com.example.bookstore.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService service;
    private static int counter = 0;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @Operation(summary = "Get all authors with their books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found list of authors",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content)})
    @GetMapping
    public List<AuthorDto> getAll() {
        counter++;
        return service.getAll();
    }

    @Operation(summary = "Get author by his id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the author found",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content)})
    @GetMapping("/{id}")
    public AuthorDto get(@PathVariable Long id) {
        counter++;
        return service.getById(id);
    }

    @Operation(summary = "Create a new author (without books)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Author created",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content)})
    @PostMapping
    public void create(@RequestBody Author author) {
        counter++;
        service.save(author);
    }

    @Operation(summary = "Edit existing author")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Author updated",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content)})
    @PutMapping
    public void update(@RequestBody Author author) {
        counter++;
        service.save(author);
    }

    @Operation(summary = "Delete author by his id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Author deleted",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content)})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        counter++;
        service.delete(id);
    }

    @GetMapping("/counter")
    public int getCounter() {
        return counter;
    }
}
