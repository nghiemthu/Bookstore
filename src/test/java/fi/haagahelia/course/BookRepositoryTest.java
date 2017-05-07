package fi.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.domain.Category;
import fi.haagahelia.course.domain.Book;
import fi.haagahelia.course.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
    private BookRepository repository;

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = repository.findByTitle("Hit");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("H");
    }
    
    @Test
    public void createBook() {
    	Book book = new Book("Hitt", "Cat", 23, "hsidf23", 123, new Category("Art"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    } 
}