// Базовий інтерфейс для замовлення
interface BookOrder {
    String getDescription();
    double getCost();
}

// Основне замовлення книги
class BasicBookOrder implements BookOrder {
    @Override
    public String getDescription() {
        return "Замовлення книги";
    }

    @Override
    public double getCost() {
        return 10.0;
    }
}

// Базовий клас для декораторів
abstract class BookOrderDecorator implements BookOrder {
    protected BookOrder bookOrder;

    public BookOrderDecorator(BookOrder bookOrder) {
        this.bookOrder = bookOrder;
    }

    @Override
    public String getDescription() {
        return bookOrder.getDescription();
    }

    @Override
    public double getCost() {
        return bookOrder.getCost();
    }
}

// Декоратор для обгортки книги
class WrappedBookOrder extends BookOrderDecorator {
    public WrappedBookOrder(BookOrder bookOrder) {
        super(bookOrder);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", з обгорткою";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }
}

// Декоратор для експрес-доставки
class ExpressDeliveryOrder extends BookOrderDecorator {
    public ExpressDeliveryOrder(BookOrder bookOrder) {
        super(bookOrder);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", з експрес-доставкою";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5.0;
    }
}

public class Main {
    public static void main(String[] args) {
        BookOrder order = new BasicBookOrder();
        order = new WrappedBookOrder(order);
        order = new ExpressDeliveryOrder(order);

        System.out.println("Опис: " + order.getDescription());
        System.out.println("Загальна вартість: $" + order.getCost());
    }
}
