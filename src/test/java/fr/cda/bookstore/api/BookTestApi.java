package fr.cda.bookstore.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.cda.bookstore.simple.metier.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
// Permet au MockMvc de se configurer pour attaquer notre API
@AutoConfigureMockMvc
public class BookTestApi {
    // Classe pour simuler des appels REST
    @Autowired
    private MockMvc mockMvc;
    // Classe de sérialisation / désérialisation
    // writeValueAsString -> Classe JAVA en entrée -> Sortie JSON String
    // readValue -> Inverse
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllBooks() throws Exception {
        // Création de notre requête au moyen de la classe MockMvcRequestBuilders
        // Utilisation de la méthode correspondant au verbe HTTP voulu, qui prend en paramètre l'URL du point d'API
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/books");
        // Test du status de la réponse, ici 200 (isOk())
        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(requestBuilder).andExpect(resultStatus);
        }

    @Test
    public void testGetByTitle() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/books/search?title=Angular");
        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        String bodyContent = mockMvc.perform(requestBuilder).andExpect(resultStatus).andReturn().getResponse().getContentAsString();
        // Désérialisation du contenu de la réponse en Book
        Book book = objectMapper.readValue(bodyContent, Book.class);
        Assertions.assertEquals("Angular", book.getBookTitle());
    }
}