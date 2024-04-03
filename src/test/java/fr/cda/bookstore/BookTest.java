package fr.cda.bookstore;

import fr.cda.bookstore.simple.metier.Book;
import fr.cda.bookstore.simple.metier.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookTest {

    @Test
    void countAllBooks() {
        Book book = new Book(2, "Java");
        Book book2 = new Book(4, "Spring");

        Assertions.assertEquals(6, book.getNbPages(), book2.getNbPages());
    }

    @Test
    void isDispo() {
        Library library = new Library();
        Book book = new Book(15, "Java");

        library.addBook(book, 0);
        Assertions.assertFalse(library.isDispo(book));
        library.addBook(book, 2);
        Assertions.assertTrue(library.isDispo(book));
    }

    @Test
    void isIndispo() {
        Library library = new Library();
        Book book = new Book(10, "Java");

        library.addBook(book, 0);
        Assertions.assertFalse(library.isDispo(book));
    }
}