package fi.roosakivila.bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import fi.roosakivila.bookstore.domain.Category;
import fi.roosakivila.bookstore.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void createNewCategoryTest() {
        Category category = new Category("Testicategory");
        categoryRepository.save(category);

        assertThat(category.getCategoryid()).isNotNull();
    }

    @Test
    public void DeleteCategoryTest() {
        Category category = new Category("Testicategory");
        categoryRepository.save(category);

        Long id = category.getCategoryid();

        categoryRepository.deleteById(id);
        assertThat(categoryRepository.findById(id)).isEmpty();
    }

    @Test
    public void FindCategoryTest() {
        List<Category> categories = categoryRepository.findByName("Programming");

        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Programming");
    }

}
