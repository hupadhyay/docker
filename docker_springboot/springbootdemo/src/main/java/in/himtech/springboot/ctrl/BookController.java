package in.himtech.springboot.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.himtech.springboot.domain.Book;
import in.himtech.springboot.repo.BookRepo;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookRepo repoBook;
	
//	public BookController(BookRepo repoBook){
//		this.repoBook = repoBook;
//	}
	
	/**
	 * CREATE
	 * @param book
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Book saveBook(@RequestBody Book book){
		return repoBook.save(book);
		
	}

	/**
	 * Retrive
	 * @param bookId
	 * @return
	 */
	@RequestMapping(value="/{bookId}", method=RequestMethod.GET)
	public Book getBook(@PathVariable Integer bookId){
		return repoBook.getOne(bookId);
	}
	
	/**
	 * Retrive All.
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public List<Book> getAllBook(){
		return repoBook.findAll();
	}
	
	/**
	 * Retrive Book by Author name.
	 * @return
	 */
	@RequestMapping(value="/author/{authorName}", method=RequestMethod.GET)
	public List<Book> getByAuthorName(@PathVariable String authorName){
		return repoBook.getByAuthor(authorName);
	}
	
	/**
	 * Delete
	 * @param bookId
	 * @return
	 */
	@RequestMapping(value="/{bookId}", method=RequestMethod.DELETE)
	public boolean deleteBook(@PathVariable int bookId){
		try{
			repoBook.delete(bookId);
			return true;
		}catch(Exception exp){
			return false;
		}
	}
}
