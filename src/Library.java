import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private int nextId = 1;

    public void seed() {
        books.add(new Book(nextId++,"Harry Potter", "J.K. Rowling", "Tiểu thuyết", LocalDate.of(1997, 6, 26)));
        books.add(new Book(nextId++,"Nàng tiên cá", "Hans Christian Andersen", "Truyện cổ tích", LocalDate.of(1837, 4, 7)));
        books.add(new Book(nextId++,"Dế Mèn Phiêu Lưu Ký", "Tô Hoài", "Thiếu nhi", LocalDate.of(1941, 1, 1)));
    }

    private static String input(Scanner sc, String label, boolean allowEmpty) {
        while (true) {
            System.out.print(label);
            String s = sc.nextLine().trim();
            if (!s.isEmpty() || allowEmpty) return s;
            System.out.println("Do not leave it blank!!");
        }
    }

    private LocalDate inputDateRequired(Scanner sc, String label) {
        while (true) {
            System.out.print(label);
            String s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.out.println("Date is required (dd/MM/yyyy)!");
                continue;
            }
            try {
                return LocalDate.parse(s, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format!! (dd/MM/yyyy)");
            }
        }
    }

    private LocalDate inputDateOptional(Scanner sc, String label) {
        while (true) {
            System.out.print(label);
            String s = sc.nextLine().trim();
            if (s.isEmpty()) return null;
            try {
                return LocalDate.parse(s, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format!! (dd/MM/yyyy)");
            }
        }
    }

    private static int inputIndex(Scanner sc, String label, int size) {
        while (true) {
            System.out.print(label);
            String s = sc.nextLine().trim();
            try {
                int idx = Integer.parseInt(s);
                if (idx >= 0 && idx < size) return idx;
                System.out.println("Index out of range! (0.." + (size - 1) + ")");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        }
    }

    public void add(Scanner sc) {
        System.out.println("Add new book");
        String title  = input(sc, "Title: ",  false);
        String author = input(sc, "Author: ", false);
        String genre  = input(sc, "Genre: ",  false);
        LocalDate date = inputDateRequired(sc, "Published date (dd/MM/yyyy): ");
        books.add(new Book(nextId++, title, author, genre, date));
        System.out.println("Done.\n");
    }

    public void edit(Scanner sc) {
        if (books.isEmpty()) {
            System.out.println("There are no books to be edited!!");
            return;
        }
        list();
        int idx = inputIndex(sc, "Select book to edit (index): ", books.size());
        Book book = books.get(idx);

        String title  = input(sc, "Title ("  + book.getTitle()  + "): ", true);
        String author = input(sc, "Author (" + book.getAuthor() + "): ", true);
        String genre  = input(sc, "Genre ("  + book.getGenre()  + "): ", true);
        LocalDate date = inputDateOptional(sc,
                "Published date (" + book.getPublishDate().format(formatter) + ") (dd/MM/yyyy): ");

        if (!title.isEmpty())  book.setTitle(title);
        if (!author.isEmpty()) book.setAuthor(author);
        if (!genre.isEmpty())  book.setGenre(genre);
        if (date != null)      book.setPublishDate(date);

        System.out.println("Edited!!\n");
    }

    public void delete(Scanner sc) {
        if (books.isEmpty()) {
            System.out.println("There are no books to be deleted!!");
            return;
        }
        list();
        int idx = inputIndex(sc, "Select book to delete (index): ", books.size());
        Book removed = books.remove(idx);
        System.out.println("Deleted: " + removed.getTitle() + "\n");
    }

    public void list() {
        if (books.isEmpty()) {
            System.out.println("No books here!!");
            return;
        }
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%-4s | %-30s | %-22s | %-14s | %-12s%n",
                "No", "Title", "Author", "Genre", "PublishedDate");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (int i = 0; i < books.size(); i++) {
            System.out.printf("%-4d | %s%n", i, books.get(i).toString());
        }
        System.out.println("-------------------------------------------------------------------------------------------\n");
    }

    public void search(Scanner sc) {
        if (books.isEmpty()) {
            System.out.println("There are no books to be searched!!");
            return;
        }
        String request = input(sc, "Keyword (title/author/genre/date): ", false).toLowerCase(Locale.ROOT);

        List<Book> results = new ArrayList<>();
        for (Book b : books) {
            String joined = (b.getTitle() + " " + b.getAuthor() + " " + b.getGenre() + " " + b.getPublishDate().format(formatter))
                    .toLowerCase(Locale.ROOT);
            if (joined.contains(request)) results.add(b);
        }

        if (results.isEmpty()) {
            System.out.println("Not found!!\n");
        } else {
            int n = results.size();
            System.out.printf("Found %d %s.%n", n, n > 1 ? "books" : "book");
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.printf("%-30s | %-22s | %-14s | %-12s%n", "Title", "Author", "Genre", "PublishedDate");
            System.out.println("-------------------------------------------------------------------------------------------");
            for (Book b : results) System.out.println(b.toString());
            System.out.println("-------------------------------------------------------------------------------------------\n");
        }
    }
}
