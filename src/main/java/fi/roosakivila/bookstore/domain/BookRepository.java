package fi.roosakivila.bookstore.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);

}
