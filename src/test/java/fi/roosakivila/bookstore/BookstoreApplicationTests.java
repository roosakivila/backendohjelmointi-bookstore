package fi.roosakivila.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import fi.roosakivila.bookstore.web.BookController;
import fi.roosakivila.bookstore.web.BookRestController;
import fi.roosakivila.bookstore.web.CategoryController;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;

	@Autowired
	private BookRestController bookRestController;

	@Autowired
	private CategoryController categoryController;

	@Test
	void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
		assertThat(bookRestController).isNotNull();
		assertThat(categoryController).isNotNull();
	}

}
