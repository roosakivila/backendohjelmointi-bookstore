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
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			Category category1 = new Category("Programming");
			crepository.save(category1);
			Category category2 = new Category("Comic");
			crepository.save(category2);
			Category category3 = new Category("Scifi");
			crepository.save(category3);

			repository
					.save(new Book("The Pragmatic Programmer", "Andrew Hunt", 1999, "9780201616224", 42.50, category1));
			repository.save(new Book("Clean Code", "Robert C. Martin", 2008, "9780132350884", 37.99, category1));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			log.info("fetch all categories");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}
		};
	}
}