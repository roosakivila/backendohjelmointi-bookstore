package fi.roosakivila.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fi.roosakivila.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // GET request /index
    @GetMapping("/index")
    public String getBooks(Model model) {
        return "index"; // index.html
    }

    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist"; // booklist.html
    }

}
