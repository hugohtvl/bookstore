package fr.cda.bookstore.simple.metier;

import javax.management.InstanceNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Library {
    private Map<Book, Integer> bookInventory;

    public Library() {
        this.bookInventory = new HashMap<>();
    }

    public void addBook(Book book, int quantity) {
        this.bookInventory.put(book, quantity);

        // NON BLOQUANT - MET A JOUR LA QUANTITE
        // this.stock.compute(book, (b,quantite) -> Optional.ofNullable(quantite).orElse(0) + qte);

        // BLOQUANT - IF -> throw Exception
        // if (this.stock.containsKey(book){
        //      throw new KeyAlreadyExistsException();
        // }
        // Nouvelle méthode de mise a jour quantité
    }

    public void addBookCopy(Book b, int qty) throws InstanceNotFoundException {
        if (this.bookInventory.containsKey(b)){
            Integer nbCopy = this.bookInventory.get(b);
            this.bookInventory.put(b, nbCopy + qty);
        } else {
            throw new InstanceNotFoundException();
        }
    }

    public void removeBook(Book book) {
        this.bookInventory.remove(book);
    }

    public boolean isDispo(Book book) {
        return this.bookInventory.get(book) > 0;
    }

    public Book findByTitle(String titre) throws InstanceNotFoundException {
        return this.bookInventory.keySet()
                .stream()
                .filter(book -> book.getBookTitle().equals(titre))
                .findFirst()
                .orElseThrow(InstanceNotFoundException::new);
    }

    public Integer getNbOfBooks(Book b) throws InstanceNotFoundException {
        return Optional.ofNullable(this.bookInventory.get(b)).orElseThrow(InstanceNotFoundException::new);
    }

    public List<Book> getAllBooksDispo() {
        return this.bookInventory.entrySet().stream().filter(book -> book.getValue() > 0).map(Map.Entry::getKey).toList();
    }
}
