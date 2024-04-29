package fr.cda.bookstore.sql.controller;

import fr.cda.bookstore.sql.DTO.BookWithAutorIdDTO;
import fr.cda.bookstore.sql.entity.BookEntity;
import fr.cda.bookstore.sql.service.BookSqlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.List;

// Annotation @RestController -> Définir une classe contenant des points d'entrées
@RestController
// Permet de préfixer l'ensemble des points d'API dans cette classe
@RequestMapping("/api/sql-books")
public class BookSqlController {
    // Défini une dépendance BookSqlService
    private BookSqlService bookSqlService;

    // Injection de dépendances via constructor
    public BookSqlController(BookSqlService bookSqlService) {
        this.bookSqlService = bookSqlService;
    }

    // Annotation @GetMapping -> Définir un point d'API GET (en paramètre, le chemin de la ressource, A CONCATENER AVEC LE REQUEST MAPPING)
    @GetMapping("")
    public List<BookEntity> getAllBooks(){
        return bookSqlService.getAllBooks();
    }

    // Annotation @GetMapping -> Définir un point d'API GET (en paramètre, le chemin de la ressource, A CONCATENER AVEC LE REQUEST MAPPING)
    @GetMapping("/{id}")
    public BookEntity getAllBooks(@PathVariable("id") Integer id) throws InstanceNotFoundException {
        return bookSqlService.getById(id);
    }

    @GetMapping("/search")
    public BookEntity getBookByTitle(@RequestParam("titre") String titre) throws InstanceNotFoundException {
        return bookSqlService.getBookByTitle(titre);
    }

//    @GetMapping("/book/{autorId}")
//    public List <BookEntity> getBooksByAutorId(@PathVariable("autorId") Integer autorId) throws InstanceNotFoundException {
//        return bookSqlService.getByAutorId(autorId);
//    }

    @GetMapping("/byAutorId/{autorId}")
    public ResponseEntity<List<BookWithAutorIdDTO>> getBooksByAutorId(@PathVariable Integer autorId) {
        List<BookWithAutorIdDTO> dtos = bookSqlService.getBooksByAutorId(autorId);
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping("")
    public ResponseEntity<BookWithAutorIdDTO> createBook(@RequestBody BookWithAutorIdDTO bookDTO) {
        BookWithAutorIdDTO createdBook = bookSqlService.createBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }
}