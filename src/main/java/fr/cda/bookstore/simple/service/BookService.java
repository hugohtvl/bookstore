package fr.cda.bookstore.simple.service;

import fr.cda.bookstore.simple.metier.Book;
import fr.cda.bookstore.simple.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.List;

// Annotation @Service -> Définir une classe qui gère les traitements entre un controller et un repository
@Service
public class BookService {
    private LibraryRepository libraryRepository;

    public BookService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Book> getAllBooks() {
        return libraryRepository.getAllBooks();
    }

    public Book getBookByTitle(String title) throws InstanceNotFoundException {
        return libraryRepository.getBookByTitle(title);
    }
}
