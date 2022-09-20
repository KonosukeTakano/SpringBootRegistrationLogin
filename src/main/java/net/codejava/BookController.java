package net.codejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class BookController {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
    private BookService bookService;
	
    @GetMapping("/books")
    public String index(Model model) {
        
        return "books/index";
    }
    
    @GetMapping("/form")
    public String form(@ModelAttribute BookForm bookForm) {
    	return "books/form";
    }
    
    //新規入力データの保存
    @PostMapping("/books")
    public String create(BookForm bookForm, @AuthenticationPrincipal CustomUserDetails user) {
    	bookService.setBook(bookForm, user);
    	return "redirect:/index";
    }
    
    //詳細画面
    @GetMapping("/books/{id}")
    public String show(@ModelAttribute BookForm bookForm, @PathVariable int id) {
    	
    	return "books/show";
    	
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@ModelAttribute BookForm bookForm, @PathVariable int id) {
    	
    	return "books/edit";
    }
    
    //データを更新
    @PostMapping("/edit/{id}")
    public String update(BookForm bookForm, @PathVariable int id) {
    	
    	return "redirect:/books/{id}";
    }
    
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
    	
    	return "redirect:/index";
    }
}
