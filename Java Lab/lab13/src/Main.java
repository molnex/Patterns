// Інтерфейс для замовлення книг
interface BookOrder {
    void placeOrder(String bookTitle);
}

// Реальна система замовлення книг
class RealBookOrder implements BookOrder {
    private String userId;

    public RealBookOrder(String userId) {
        this.userId = userId;
    }

    @Override
    public void placeOrder(String bookTitle) {
        System.out.println("Замовлення на книгу: " + bookTitle + " успішно оформлено для користувача: " + userId);
    }
}

// Проксі для замовлення книг
class BookOrderProxy implements BookOrder {
    private RealBookOrder realBookOrder;
    private String userId;
    private boolean hasAccess;

    public BookOrderProxy(String userId, boolean hasAccess) {
        this.userId = userId;
        this.hasAccess = hasAccess;
    }

    @Override
    public void placeOrder(String bookTitle) {
        if (hasAccess) {
            if (realBookOrder == null) {
                realBookOrder = new RealBookOrder(userId);
            }
            realBookOrder.placeOrder(bookTitle);
        } else {
            System.out.println("Користувач " + userId + " не має доступу до замовлення книги.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BookOrder userWithAccess = new BookOrderProxy("molnex", true);
        userWithAccess.placeOrder("1984");

        BookOrder userWithoutAccess = new BookOrderProxy("vetalbka", false);
        userWithoutAccess.placeOrder("Animal Farm");
    }
}
