class LibraryOrderSystem {
    // Єдиний екземпляр класу
    private static LibraryOrderSystem instance;

    // Приватний конструктор, щоб уникнути створення об'єктів ззовні
    private LibraryOrderSystem() {
        System.out.println("Система замовлення книг ініціалізована.");
    }

    // Публічний метод для отримання єдиного екземпляра класу
    public static synchronized LibraryOrderSystem getInstance() {
        if (instance == null) {
            instance = new LibraryOrderSystem();
        }
        return instance;
    }

    // Метод для створення замовлення на книгу
    public void createOrder(String bookTitle) {
        System.out.println("Замовлення на книгу \"" + bookTitle + "\" створене.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Отримуємо єдиний екземпляр системи замовлення книг
        LibraryOrderSystem orderSystem = LibraryOrderSystem.getInstance();
        orderSystem.createOrder("Гаррі Поттер і філософський камінь");

        // Перевірка, що при повторному зверненні отримується той же екземпляр
        LibraryOrderSystem anotherOrderSystem = LibraryOrderSystem.getInstance();
        anotherOrderSystem.createOrder("Володар Перснів");

        // Порівняння екземплярів
        System.out.println("Один і той самий екземпляр: " + (orderSystem == anotherOrderSystem));
    }
}