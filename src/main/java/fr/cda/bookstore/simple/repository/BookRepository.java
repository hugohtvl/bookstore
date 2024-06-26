package fr.cda.bookstore.simple.repository;

import fr.cda.bookstore.simple.metier.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// Annotation @Repository -> Définir une classe contenant des accès aux données
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
