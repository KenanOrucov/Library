package com.library.libraryservice.service;

import com.library.libraryservice.client.BookServiceClient;
import com.library.libraryservice.dto.AddBookRequest;
import com.library.libraryservice.dto.LibraryDto;
import com.library.libraryservice.exception.LibraryNotFoundException;
import com.library.libraryservice.model.Library;
import com.library.libraryservice.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;

    public LibraryDto getAllBooksInLibraryById(String id){
        Library library = libraryRepository.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("library could not found by id: "+ id));

        LibraryDto libraryDto = new LibraryDto(library.getId(),
                library.getUserBook()
                        .stream()
                        .map(book -> bookServiceClient.getBookById(book).getBody())// feign
                        .collect(Collectors.toList()));

        System.out.println(libraryDto);
        return libraryDto;
    }

    public LibraryDto createLibrary(){
        Library newLibrary = libraryRepository.save(new Library(null));

        LibraryDto libraryDto = new LibraryDto();
        libraryDto.setId(newLibrary.getId());
        libraryDto.setUserBookList(new ArrayList<>());

        System.out.println(newLibrary.getId());
        System.out.println(newLibrary.getUserBook());

        return libraryDto;
    }

    public void addBookToLibrary(AddBookRequest request){
        String bookId = bookServiceClient.getBookByIsbn(request.getIsbn()).getBody().getBookId();
        System.out.println(bookId);

        Library library =  libraryRepository.findById(request.getId())
                .orElseThrow(() -> new LibraryNotFoundException("library could not found by id: "+ request.getId()));

        library.getUserBook().add(bookId);

        System.out.println(library.getUserBook());
        libraryRepository.save(library);
    }

    public List<String> getAllLibraries() {
        return libraryRepository.findAll()
                .stream()
                .map(l-> l.getId())
                .collect(Collectors.toList());

    }
}



















