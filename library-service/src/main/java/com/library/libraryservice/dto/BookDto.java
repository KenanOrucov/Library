package com.library.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    private BookIdDto id;
    private String title;
    private int bookYear;
    private String author;
    private String pressName;
    private String isbn;

    public BookDto(BookIdDto id) {
        this.id = id;
    }
}
