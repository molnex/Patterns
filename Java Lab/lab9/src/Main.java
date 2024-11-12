import java.util.ArrayList;
import java.util.List;

// Компонент (базовий інтерфейс)
interface LibraryComponent {
    void showDetails();
}

// Лист (індивідуальний елемент - книга)
class Book implements LibraryComponent {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public void showDetails() {
        System.out.println("Книга: " + title);
    }
}

// Композит (категорія книг)
class BookCategory implements LibraryComponent {
    private String name;
    private List<LibraryComponent> components = new ArrayList<>();

    public BookCategory(String name) {
        this.name = name;
    }

    public void addComponent(LibraryComponent component) {
        components.add(component);
    }

    public void removeComponent(LibraryComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Категорія: " + name);
        for (LibraryComponent component : components) {
            component.showDetails();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BookCategory fiction = new BookCategory("Художня література");
        BookCategory mystery = new BookCategory("Детективи");
        BookCategory sciFi = new BookCategory("Наукова фантастика");

        Book book1 = new Book("Дюна");
        Book book2 = new Book("1984");
        Book book3 = new Book("Шерлок Холмс");

        fiction.addComponent(book1);
        sciFi.addComponent(book2);
        mystery.addComponent(book3);

        fiction.addComponent(mystery);
        fiction.addComponent(sciFi);

        fiction.showDetails();
    }
}
