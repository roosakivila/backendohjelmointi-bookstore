package fi.roosakivila.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import fi.roosakivila.bookstore.domain.AppUser;
import fi.roosakivila.bookstore.domain.AppUserRepository;
import fi.roosakivila.bookstore.domain.Category;

@DataJpaTest
public class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository appUserRepository;

    @Test
    public void createNewUserTest() {
        AppUser user = new AppUser("testuser", "password", "email", "user");
        appUserRepository.save(user);

        assertThat(user.getId()).isNotNull();
    }

    @Test
    public void DeleteUserTest() {
        AppUser user = new AppUser("testuser", "password", "email", "user");
        appUserRepository.save(user);

        Long id = user.getId();

        appUserRepository.deleteById(id);
        assertThat(appUserRepository.findById(id)).isEmpty();
    }

    @Test
    public void FindUserTest() {
        AppUser users = appUserRepository.findByUsername("user");

        assertThat(users.getRole()).isEqualTo("USER");
    }

}
