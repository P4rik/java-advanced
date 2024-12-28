package items;

import annotations.JsonField;
import annotations.XmlField;
/**
 * Represents a items.Book with a title, author, and publication year.
 * This class uses annotations to map the fields to JSON and XML formats.
 */
public class Book {

    /**
     * The title of the book.
     * Mapped to the JSON field "title" and XML field "Title".
     */
    @JsonField("title")
    @XmlField("Title")
    private String title;

    /**
     * The author of the book.
     * Mapped to the JSON field "author" and XML field "Author".
     */
    @JsonField("author")
    @XmlField("Author")
    private String author;

    /**
     * The year the book was published.
     * Mapped to the JSON field "year" and XML field "Year".
     */
    @JsonField("year")
    @XmlField("Year")
    private int year;

    /**
     * Constructs a new items.Book object with the specified title, author, and year.
     *
     * @param title the title of the book
     * @param author the author of the book
     * @param year the year the book was published
     */
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Getters and setters can be added here if needed for serialization or other purposes
}
