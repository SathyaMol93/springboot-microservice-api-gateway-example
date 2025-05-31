package dev.sathyamolagoda.book_service.services.impl;

import dev.sathyamolagoda.book_service.dto.request.BookCreateRequest;
import dev.sathyamolagoda.book_service.dto.response.BookResponse;
import dev.sathyamolagoda.book_service.dto.update.BookUpdateRequest;
import dev.sathyamolagoda.book_service.exception.ResourceNotFoundException;
import dev.sathyamolagoda.book_service.mapper.AuthorMapper;
import dev.sathyamolagoda.book_service.mapper.BookMapper;
import dev.sathyamolagoda.book_service.model.Author;
import dev.sathyamolagoda.book_service.model.Book;
import dev.sathyamolagoda.book_service.repository.AuthorRepository;
import dev.sathyamolagoda.book_service.repository.BookRepository;
import dev.sathyamolagoda.book_service.services.BookService;
import jakarta.ws.rs.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Implementation of the BookService interface.
 * Provides methods for managing books and authors.
 */
@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    /**
     * Retrieves all books with their associated authors.
     *
     * @return A list of BookResponse objects containing book and author details.
     * @throws ResourceNotFoundException If an author is not found for a book.
     * @throws BadRequestException       If the UUID format is invalid.
     */
    @Override
    public List<BookResponse> getAllBooks() {
        try {
            List<Book> books = bookRepository.findAll();

            Set<UUID> authorIds = books.stream()
                    .map(book -> UUID.fromString(book.getAuthor()))
                    .collect(Collectors.toSet());

            Map<UUID, Author> authorMap = authorRepository.findAllById(authorIds)
                    .stream()
                    .collect(Collectors.toMap(Author::getId, Function.identity()));

            return books.stream()
                    .map(book -> {
                        UUID authorId = UUID.fromString(book.getAuthor());
                        Author author = Optional.ofNullable(authorMap.get(authorId))
                                .orElseThrow(() -> new ResourceNotFoundException("Author not found with ID: " + authorId));
                        return BookMapper.toResponse(book, AuthorMapper.toResponse(author));
                    })
                    .toList();

        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid UUID format in book data", e);
        }
    }

    /**
     * Retrieves a book by its ID along with its associated author.
     *
     * @param id The ID of the book to retrieve.
     * @return A BookResponse object containing the book and author details.
     * @throws ResourceNotFoundException If the book or author is not found.
     * @throws BadRequestException       If the provided ID is not a valid UUID.
     */
    @Override
    public BookResponse getBookById(String id) {
        try {
            Book book = bookRepository.findById(UUID.fromString(id))
                    .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + id));

            Author author = authorRepository.findById(UUID.fromString(book.getAuthor()))
                    .orElseThrow(() -> new ResourceNotFoundException("Author not found with ID: " + book.getAuthor()));

            return BookMapper.toResponse(book, AuthorMapper.toResponse(author));
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid UUID format: " + id);
        }
    }

    /**
     * Creates a new book.
     *
     * @param bookCreateRequest The request object containing the book details.
     * @return A BookResponse object representing the created book.
     * @throws ResourceNotFoundException If the author is not found.
     * @throws BadRequestException       If the author ID is not a valid UUID.
     */
    @Override
    public BookResponse createBook(BookCreateRequest bookCreateRequest) {
        try {
            Book book = BookMapper.toEntity(bookCreateRequest);
            Book savedBook = bookRepository.save(book);

            Author author = authorRepository.findById(UUID.fromString(book.getAuthor()))
                    .orElseThrow(() -> new ResourceNotFoundException("Author not found with ID: " + book.getAuthor()));

            return BookMapper.toResponse(savedBook, AuthorMapper.toResponse(author));
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException("Invalid UUID format: " + bookCreateRequest.getAuthorId());
        }
    }

    /**
     * Updates an existing book.
     *
     * @param id                 The ID of the book to update.
     * @param bookUpdateRequest The request object containing the updated book details.
     * @return A BookResponse object representing the updated book.
     * @throws ResourceNotFoundException If the book or author is not found.
     * @throws BadRequestException       If the provided ID or author ID is not a valid UUID.
     */
    @Override
    public BookResponse updateBook(String id, BookUpdateRequest bookUpdateRequest) {
        try {
            Book existingBook = bookRepository.findById(UUID.fromString(id))
                    .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + id));
            BookMapper.updateEntity(existingBook, bookUpdateRequest);
            Book savedBook = bookRepository.save(existingBook);

            Author author = authorRepository.findById(UUID.fromString(savedBook.getAuthor()))
                    .orElseThrow(() -> new ResourceNotFoundException("Author not found with ID: " + savedBook.getAuthor()));

            return BookMapper.toResponse(savedBook, AuthorMapper.toResponse(author));
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException("Invalid UUID format: " + id);
        }
    }

    /**
     * Deletes a book by its ID.
     *
     * @param id The ID of the book to delete.
     * @throws ResourceNotFoundException If the book is not found.
     * @throws BadRequestException       If the provided ID is not a valid UUID.
     */
    @Override
    public void deleteBook(String id) {
        try {
            Book book = bookRepository.findById(UUID.fromString(id))
                    .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + id));
            bookRepository.delete(book.getId());
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException("Invalid UUID format: " + id);
        }
    }
}
