package com.library.bookservice;

import com.library.bookservice.model.Book;
import com.library.bookservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@RequiredArgsConstructor
public class BookServiceApplication implements CommandLineRunner {

	private final BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("Dunyanin gozu", 2000, "Robert Jordan", "salam", "1234");
		Book book2 = new Book("Yuzuklerin efendisi", 1999, "Orujov", "salamNecesen", "6789");
		Book book3 = new Book("Harry Potter", 2565, "Kanan Jordan", "necesen", "1111");

		List<Book> books = bookRepository.saveAll(Arrays.asList(book1, book2, book3));
		System.out.println(books);
	}
}
