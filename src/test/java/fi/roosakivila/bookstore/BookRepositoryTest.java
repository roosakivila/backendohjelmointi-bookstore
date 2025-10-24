package fi.roosakivila.bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import fi.roosakivila.bookstore.domain.Book;
import fi.roosakivila.bookstore.domain.BookRepository;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void createNewBookTest() {
        Book book = new Book("Testikirja", "Testikirjailija", 2025, "123456", 19.90, null);
        bookRepository.save(book);

        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void DeleteBookTest() {
        Book book = new Book("Testikirja", "Testikirjailija", 2025, "123456", 19.90, null);
        bookRepository.save(book);

        Long id = book.getId();

        bookRepository.deleteById(id);
        assertThat(bookRepository.findById(id)).isEmpty();
    }

    @Test
    public void FindBookTest() {
        List<Book> books = bookRepository.findByTitle("The Pragmatic Programmer");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Andrew Hunt");
    }

}
