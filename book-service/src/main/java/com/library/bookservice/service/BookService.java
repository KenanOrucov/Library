package com.library.bookservice.service;

import com.library.bookservice.dto.BookDto;
import com.library.bookservice.dto.BookIdDto;
import com.library.bookservice.exception.BookNotFoundException;
import com.library.bookservice.model.Book;
import com.library.bookservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<BookDto> getAllBooks(){
        List<Book>books =  bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book: books){
            bookDtos.add(new BookDto(new BookIdDto(book.getId(), book.getIsbn()), book.getTitle(), book.getBookYear(), book.getAuthor(), book.getPressName(), book.getIsbn()));
        }
        return bookDtos;
    }

    public BookIdDto findByIsbn(String  isbn){
        return bookRepository.getBookByIsbn(isbn)
                .map(book -> new BookIdDto(book.getId(), book.getIsbn()))
                .orElseThrow(() -> new BookNotFoundException("Book could not found  by isbn: " + isbn));
    }

    public BookDto findBookDetailsById(String id){
        return bookRepository.findById(id)
                .map(t-> new BookDto(new BookIdDto(t.getId(), t.getIsbn()), t.getTitle(), t.getBookYear(), t.getAuthor(), t.getPressName(), t.getIsbn()))
                .orElseThrow(()-> new BookNotFoundException("Book could not found by id: " + id));
    }
}
















