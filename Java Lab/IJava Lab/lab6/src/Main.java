import java.util.Stack;

class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void read() {
        System.out.println("Читання книги: " + title);
    }
}

class BookPool {
    private Stack<Book> availableBooks;

    public BookPool(int size) {
        availableBooks = new Stack<>();
        for (int i = 1; i <= size; i++) {
            availableBooks.push(new Book("Книга " + i));
        }
    }

    public Book acquireBook() {
        if (availableBooks.isEmpty()) {
            System.out.println("Немає доступних книг у пулі.");
            return null;
        }
        return availableBooks.pop();
    }

    public void releaseBook(Book book) {
        availableBooks.push(book);
    }
}

public class Main {
    public static void main(String[] args) {
        BookPool pool = new BookPool(3);

        Book book1 = pool.acquireBook();
        if (book1 != null) {
            book1.read();
            pool.releaseBook(book1);
        }

        Book book2 = pool.acquireBook();
        if (book2 != null) {
            book2.read();
            pool.releaseBook(book2);
        }

        Book book3 = pool.acquireBook();
        if (book3 != null) {
            book3.read();
            pool.releaseBook(book3);
        }

        Book book4 = pool.acquireBook();  // Спроба отримати більше, ніж є в пулі
    }
}
