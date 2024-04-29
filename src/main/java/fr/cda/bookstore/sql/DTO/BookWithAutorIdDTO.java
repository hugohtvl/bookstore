package fr.cda.bookstore.sql.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookWithAutorIdDTO {
    private Integer bookId;
    private String title;
    private Integer autorId;

    // Constructeur
    public BookWithAutorIdDTO(Integer id, String title, Integer autorId) {
        this.bookId = id;
        this.title = title;
        this.autorId = autorId;
    }
}

