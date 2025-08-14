import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private LocalDate publishDate;

    public Book(int id, String title, String author, String genre, LocalDate publishDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishDate = publishDate;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public LocalDate getPublishDate() { return publishDate; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setPublishDate(LocalDate publishDate) { this.publishDate = publishDate; }

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String toString() {
        return String.format("%-4d | %-30s | %-22s | %-14s | %-12s",
                id, title, author, genre, publishDate.format(DTF));
    }
}
