package fr.cda.bookstore.repository;

import fr.cda.bookstore.metier.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private List<Book> books;

    public BookRepository() {
        books = new ArrayList<>();
        books.add(new Book(2, "Java"));
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public Book getBookByTitle(String title) {
        return books.stream().filter(book -> book.getBookTitle().equals(title)).findFirst().orElse(null);
    }
}
