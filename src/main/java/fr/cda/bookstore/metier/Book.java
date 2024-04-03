package fr.cda.bookstore.metier;

import java.util.Objects;

public class Book {

    private int nbPages;

    private String bookTitle;

    public Book(int nbPages, String bookTitle) {
        this.nbPages = nbPages;
        this.bookTitle = bookTitle;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return nbPages == book.nbPages && Objects.equals(bookTitle, book.bookTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nbPages, bookTitle);
    }
}
