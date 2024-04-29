package fr.cda.bookstore.sql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.cda.bookstore.sql.DTO.BookWithAutorIdDTO;
import fr.cda.bookstore.sql.entity.BookEntity;
import fr.cda.bookstore.sql.repository.BookSqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.ArrayList;
import java.util.List;

// Annotation @Service -> Définir une classe qui gère les traitements entre un controller et un repository
@Service
public class BookSqlService {
    private BookSqlRepository bookSqlRepository;

    @Autowired
    private ObjectMapper objectMapper; // Injection d'ObjectMapper

    public BookSqlService(BookSqlRepository bookSqlRepository) {
        this.bookSqlRepository = bookSqlRepository;
    }

    public List<BookWithAutorIdDTO> getBooksByAutorId(Integer autorId) {
        List<BookEntity> bookEntities = bookSqlRepository.findByAutorId(autorId);
        List<BookWithAutorIdDTO> dtos = new ArrayList<>();

        for (BookEntity entity : bookEntities) {
            // Utilisation de l'ObjectMapper pour convertir l'entité en DTO
            BookWithAutorIdDTO dto = objectMapper.convertValue(entity, BookWithAutorIdDTO.class);
            dtos.add(dto);
        }

        return dtos;
    }

    public List<BookEntity> getAllBooks(){
        return this.bookSqlRepository.findAll();
    }

    public BookEntity getBookByTitle(String titre) {
        return bookSqlRepository.findByTitleIgnoreCase(titre);
    }

    public BookEntity getById(Integer id) throws InstanceNotFoundException {
        return bookSqlRepository.findById(id).orElseThrow(InstanceNotFoundException::new);
    }

    public BookWithAutorIdDTO createBook(BookWithAutorIdDTO bookDTO) {
        // Convertir le DTO en entité
        BookEntity bookEntity = objectMapper.convertValue(bookDTO, BookEntity.class);

        // Enregistrer l'entité dans la base de données
        BookEntity savedBookEntity = bookSqlRepository.save(bookEntity);

        // Convertir l'entité en DTO et le renvoyer
        return objectMapper.convertValue(savedBookEntity, BookWithAutorIdDTO.class);
    }
}
