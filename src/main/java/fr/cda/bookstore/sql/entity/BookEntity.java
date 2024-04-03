package fr.cda.bookstore.sql.entity;

import jakarta.persistence.*;

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

    @Column(name="nb_pages")
    private Integer nbPages;

    //TODO vérifier ici la source de données
    @ManyToOne
    @JoinColumn(name = "id", updatable = false, insertable = false)
    private AutorEntity autor;

    @Column(name = "autor_id")
    private Integer autorId;


    public BookEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNbPages() {
        return nbPages;
    }

    public void setNbPages(Integer nbPages) {
        this.nbPages = nbPages;
    }
}
