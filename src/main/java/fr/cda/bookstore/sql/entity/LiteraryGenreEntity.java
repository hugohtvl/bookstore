package fr.cda.bookstore.sql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="literary_genre")
public class LiteraryGenreEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String genre;

    @ManyToMany
    @JoinTable(
            name = "books_has_literary_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    Set<BookEntity> likes;

    public LiteraryGenreEntity() {
    }
}
