import java.util.HashMap;
import java.util.Map;

// Flyweight клас, що представляє книгу
class Book {
    private final String title;
    private final String author;
    private final String genre;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getDescription() {
        return title + " by " + author + " [" + genre + "]";
    }
}

// Flyweight Factory, що створює та зберігає екземпляри книг
class BookFactory {
    private static final Map<String, Book> books = new HashMap<>();

    public static Book getBook(String title, String author, String genre) {
        String key = title + author + genre;
        if (!books.containsKey(key)) {
            books.put(key, new Book(title, author, genre));
            System.out.println("Створення нової книги: " + title);
        } else {
            System.out.println("Повторне використання книги: " + title);
        }
        return books.get(key);
    }
}

// Контекстний клас, що представляє екземпляр книги для замовлення з додатковими атрибутами (напр., ідентифікатор користувача)
class BookOrder {
    private final Book book;
    private final String userId;

    public BookOrder(Book book, String userId) {
        this.book = book;
        this.userId = userId;
    }

    public void placeOrder() {
        System.out.println("Замовлення книги: " + book.getDescription() + " для користувача: " + userId);
    }
}

public class Main {
    public static void main(String[] args) {
        Book book1 = BookFactory.getBook("1984", "George Orwell", "Dystopian");
        BookOrder order1 = new BookOrder(book1, "molnex");

        Book book2 = BookFactory.getBook("1984", "George Orwell", "Dystopian");
        BookOrder order2 = new BookOrder(book2, "vetalbka");

        order1.placeOrder();
        order2.placeOrder();
    }
}
