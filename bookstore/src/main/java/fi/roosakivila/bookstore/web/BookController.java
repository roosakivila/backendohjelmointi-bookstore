package fi.roosakivila.bookstore.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.roosakivila.bookstore.domain.Book;
import fi.roosakivila.bookstore.domain.BookRepository;
import fi.roosakivila.bookstore.domain.CategoryRepository;

@Controller
public class BookController {

    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;

    public BookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
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

    @RequestMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook"; // addbook.html
    }

    @PostMapping("/save")
    public String save(Book book) {
        bookRepository.save(book);
        return "redirect:booklist";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        bookRepository.deleteById(id);
        return "redirect:../booklist";
    }

    //  Edit book
    @GetMapping("/edit/{id}")
    public String modifyBook(@PathVariable("id") Long id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryRepository.findAll());
        return "editbook"; // editbook.html
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login"; // login.html
    }
}
