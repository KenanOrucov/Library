package com.library.libraryservice.exception;

//record - java terefinden yaradilan final class kimi dusun.
//getter ve contructor olur icinde
public record ExceptionMessage(String timesTamp,
                               int status,
                               String error,
                               String message,
                               String path) {
}
