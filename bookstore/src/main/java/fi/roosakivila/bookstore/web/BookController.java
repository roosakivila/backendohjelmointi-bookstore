package fi.roosakivila.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    // GET request /index
    @GetMapping("/index")
    public String getBooks(Model model) {
        return "index"; // index.html
    }

}
