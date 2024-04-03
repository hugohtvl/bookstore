package fr.cda.bookstore.sql.repository;

import fr.cda.bookstore.sql.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// Créer une interface qui étend JpaRepository pour avoir accès aux méthodes de bases (CRUD)
// 2 types générique à passer à JpaRepository : Classe entité et type de la clé primaire (en général Integer ou Long)
public interface BookSqlRepository extends JpaRepository<BookEntity, Integer> {
    BookEntity findByTitleIgnoreCase(String title);
}