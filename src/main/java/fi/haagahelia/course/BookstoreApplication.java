package fi.haagahelia.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.domain.Category;
import fi.haagahelia.course.domain.CategoryRepository;
import fi.haagahelia.course.domain.Book;
import fi.haagahelia.course.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Comic"));
			crepository.save(new Category("Science"));
			crepository.save(new Category("Law"));
			
			repository.save(new Book("Shie", "Ain", 12,"324n" ,342, crepository.findByName("Comic").get(0)));
			repository.save(new Book("Nenp", "Tni", 23,"fm-329",454, crepository.findByName("Law").get(0)));	
			
			
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}


