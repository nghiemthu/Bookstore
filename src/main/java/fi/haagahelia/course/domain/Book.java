package fi.haagahelia.course.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private int year;
    private float price;
   
    @ManyToOne
    @JoinColumn(name = "categoryid")
    public Category category;

    public Book() {}

	public Book(String title, String author, int year, String isbn, float price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setCategory(Category category){
		this.category = category;
	}
	
	public Category getCategory(){
		return category;
	}
	
	@Override
	public String toString() {
		if (this.category != null)
			return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", year=" + year + " category =" + this.getCategory() + ", price=" + price + "]";		
		else
			return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", year=" + year + ", price=" + price + "]";
	}
}
