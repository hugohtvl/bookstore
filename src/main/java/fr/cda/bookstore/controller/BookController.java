package fr.cda.bookstore.controller;

import fr.cda.bookstore.metier.Book;
import fr.cda.bookstore.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.InstanceNotFoundException;
import java.util.List;

// Annotation @RestController -> Définir une classe contenant des points d'entrées
@RestController
// Permet de préfixer l'ensemble des points d'API dans cette classe
@RequestMapping("/api/books")
public class BookController {
    // Défini une dépendance BookService
    private BookService bookService;

    // Injection de dépendances via constructor
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Annotation @GetMapping -> Définir un point d'API GET (en paramètre, le chemin de la ressource, A CONCATENER AVEC LE REQUEST MAPPING)
    @GetMapping("")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/search")
    public Book getBookByTitle(@RequestParam("title") String title) throws InstanceNotFoundException {
        return bookService.getBookByTitle(title);
    }
}
