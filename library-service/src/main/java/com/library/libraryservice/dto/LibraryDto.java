package com.library.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LibraryDto {
    private String id;
    private List<BookDto> userBookList;

    public LibraryDto(List<BookDto> userBook) {
        if (userBook == null) {
            this.userBookList = new ArrayList<>();
        } else {
            this.userBookList = userBook;
        }
    }

    @Override
    public String toString() {
        return "LibraryDto{" +
                "id='" + id + '\'' +
                ", userBookList=" + userBookList +
                '}';
    }
}
