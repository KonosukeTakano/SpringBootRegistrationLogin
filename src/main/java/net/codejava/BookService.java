package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
//	投稿機能
	public void setBook(BookForm form, @AuthenticationPrincipal CustomUserDetails user) {
		Book book = new Book();
		book.setId(user.getId());
		book.setTitle(form.getTitle());
		book.setBody(form.getBody());
		bookRepository.save(book);
	}
	
//	投稿全件取得
	public List<Book> findAllBooks(){
		return bookRepository.findAll();
	}
}
