package in.himtech.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.himtech.springboot.domain.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{
	
	@Query(value="from Book where author=?1")
	public List<Book> getByAuthor(String author);

}
