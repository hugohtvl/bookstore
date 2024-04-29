package fr.cda.bookstore.sql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
// @Entity -> Classe lié à une table dans la BDD
@Entity
// @Table -> Nom de la table à lier à l'entité
@Table(name="book")
public class BookEntity {
    // @Id : Spécifie que l'attribut qui suit sera la clé primaire de l'objet
    @Id
    // @GeneratedValue : Auto increment (IDENTITY) géré par le SGBD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Définir le nom de la colonne à rattacher à l'attribut de la classe
    @Column(name="id")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="nb_pages")
    private Integer nbPages;

    @Column(name="etat")
    private String etat;

    @ManyToOne
    @JoinColumn(name = "autor_id", updatable = false, insertable = false)
    // On peut récupérer l'entité entière
    private AutorEntity autor;

    // Ou uniquement le champ id
    @Column(name = "autor_id")
    private Integer autorId;

    @ManyToMany(mappedBy = "likes") // Correspondant à la propriété 'likes' de LiteraryGenreEntity
    Set<LiteraryGenreEntity> likedGenres;

    public BookEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(nbPages, that.nbPages) && Objects.equals(etat, that.etat) && Objects.equals(autor, that.autor) && Objects.equals(autorId, that.autorId) && Objects.equals(likedGenres, that.likedGenres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, nbPages, etat, autor, autorId, likedGenres);
    }
}