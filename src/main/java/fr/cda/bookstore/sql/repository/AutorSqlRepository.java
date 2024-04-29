package fr.cda.bookstore.sql.repository;

import fr.cda.bookstore.sql.entity.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorSqlRepository extends JpaRepository<AutorEntity, Integer> {
}
