package fr.cda.bookstore.simple.repository;

import fr.cda.bookstore.simple.metier.Library;
import fr.cda.bookstore.simple.metier.Book;
import org.springframework.stereotype.Repository;

import javax.management.InstanceNotFoundException;
import java.util.List;

@Repository
public class LibraryRepository {
    private Library library;

    public LibraryRepository() {
        library = new Library();
        Book book = new Book(2, "Java");
        library.addBook(book, 0);
        Book book2 = new Book(10, "Angular");
        library.addBook(book2, 0);
    }

    public void addNewBook(Book book, int copy){
        library.addBook(book, copy);
    }

    public List<Book> getAllBooks(){
        return library.getAllBooksDispo();
    }

    public Book getBookByTitle(String title) throws InstanceNotFoundException {
        return library.findByTitle(title);
    }
}
