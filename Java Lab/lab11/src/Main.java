// Система інвентаря книг
class InventorySystem {
    public boolean checkAvailability(String bookTitle) {
        System.out.println("Перевірка наявності книги: " + bookTitle);
        return true; // У спрощеній версії завжди повертаємо, що книга доступна
    }
}

// Система членства
class MembershipSystem {
    public boolean validateMembership(String memberId) {
        System.out.println("Перевірка членства для користувача: " + memberId);
        return true; // Спрощена валідація
    }
}

// Система оплати
class PaymentSystem {
    public boolean processPayment(String memberId, double amount) {
        System.out.println("Обробка оплати для користувача " + memberId + " на суму: $" + amount);
        return true; // Спрощена версія, оплата завжди успішна
    }
}

// Фасад для спрощення замовлення книги
class BookOrderFacade {
    private InventorySystem inventorySystem;
    private MembershipSystem membershipSystem;
    private PaymentSystem paymentSystem;

    public BookOrderFacade() {
        this.inventorySystem = new InventorySystem();
        this.membershipSystem = new MembershipSystem();
        this.paymentSystem = new PaymentSystem();
    }

    public void placeOrder(String bookTitle, String memberId, double amount) {
        System.out.println("=== Оформлення замовлення на книгу ===");
        if (inventorySystem.checkAvailability(bookTitle) &&
                membershipSystem.validateMembership(memberId) &&
                paymentSystem.processPayment(memberId, amount)) {
            System.out.println("Замовлення успішно оформлено для книги: " + bookTitle);
        } else {
            System.out.println("Помилка при оформленні замовлення.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BookOrderFacade facade = new BookOrderFacade();
        facade.placeOrder("1984", "molnex", 15.0);
    }
}
