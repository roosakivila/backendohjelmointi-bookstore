package fi.roosakivila.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.roosakivila.bookstore.domain.Book;
import fi.roosakivila.bookstore.domain.BookRepository;
import fi.roosakivila.bookstore.domain.Category;
import fi.roosakivila.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("The Pragmatic Programmer", "Andrew Hunt", 1999, "9780201616224", 42.50));
			repository.save(new Book("Clean Code", "Robert C. Martin", 2008, "9780132350884", 37.99));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

	@Bean
	public CommandLineRunner categoryDemo(CategoryRepository repository) {
		return (args) -> {
			log.info("save a couple of categories");
			repository.save(new Category("Programming"));
			repository.save(new Category("Comic"));
			repository.save(new Category("Scifi"));

			log.info("fetch all categories");
			for (Category category : repository.findAll()) {
				log.info(category.toString());
			}
		};
	}
}