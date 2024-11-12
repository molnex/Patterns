// Клас для збереження інформації про замовлення
class BookOrder implements Cloneable {
    private String bookTitle;
    private String customerName;

    public BookOrder(String bookTitle, String customerName) {
        this.bookTitle = bookTitle;
        this.customerName = customerName;
    }

    // Метод для клонування об'єкта
    @Override
    protected BookOrder clone() {
        try {
            return (BookOrder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Помилка клонування замовлення", e);
        }
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Замовлення книги: " + bookTitle + " для клієнта " + customerName;
    }
}

// Демонстрація використання патерну Prototype
public class Main {
    public static void main(String[] args) {
        // Створення початкового замовлення
        BookOrder originalOrder = new BookOrder("Гаррі Поттер і філософський камінь", "Віталій");

        // Копіювання початкового замовлення для іншого клієнта
        BookOrder copiedOrder = originalOrder.clone();
        copiedOrder.setCustomerName("Василь");

        // Виведення замовлень
        System.out.println(originalOrder);
        System.out.println(copiedOrder);
    }
}
