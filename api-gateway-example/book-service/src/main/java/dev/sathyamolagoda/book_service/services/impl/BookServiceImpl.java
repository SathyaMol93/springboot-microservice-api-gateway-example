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

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

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
        } catch (ResourceNotFoundException e) {
            throw e; // already meaningful
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve books and authors", e);
        }
    }


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
        } catch (ResourceNotFoundException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("Unexpected error occurred while retrieving the book", ex);
        }
    }

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
        } catch (ResourceNotFoundException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("Unexpected error occurred while creating the book", ex);
        }
    }

    @Override
    public BookResponse updateBook(String id, BookUpdateRequest bookUpdateRequest) {
        try {
            Book existingBook = bookRepository.findById(UUID.fromString(id))
                    .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + id));

            Book updatedBook = BookMapper.updateEntity(existingBook, bookUpdateRequest);

            Book savedBook = bookRepository.save(updatedBook);

            Author author = authorRepository.findById(UUID.fromString(savedBook.getAuthor()))
                    .orElseThrow(() -> new ResourceNotFoundException("Author not found with ID: " + savedBook.getAuthor()));

            return BookMapper.toResponse(savedBook, AuthorMapper.toResponse(author));
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException("Invalid UUID format: " + id);
        } catch (ResourceNotFoundException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("Unexpected error occurred while updating the book", ex);
        }
    }

    @Override
    public void deleteBook(String id) {
        try {
            Book book = bookRepository.findById(UUID.fromString(id))
                    .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + id));
            bookRepository.delete(book.getId());
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException("Invalid UUID format: " + id);
        } catch (Exception ex) {
            throw new RuntimeException("Unexpected error occurred while deleting the book", ex);
        }
    }
}
