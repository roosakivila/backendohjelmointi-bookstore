package fi.roosakivila.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import fi.roosakivila.bookstore.domain.Book;
import fi.roosakivila.bookstore.domain.Category;
import fi.roosakivila.bookstore.domain.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categorylist")
    public String categoryList(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist"; // categorylist.html
    }

    @RequestMapping("/addcategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory"; // addcategory.html
    }

    @PostMapping("/savecategory")
    public String saveCategory(Category category) {
        categoryRepository.save(category);
        return "redirect:categorylist";
    }

}
