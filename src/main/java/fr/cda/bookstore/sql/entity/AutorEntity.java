package fr.cda.bookstore.sql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "autor")
public class AutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "lastname")
    private String lastname;

    @Column(name="firstname")
    private String firstname;

    @Column(name="birth_date")
    private String birthDate;

    public AutorEntity() {
    }
}
