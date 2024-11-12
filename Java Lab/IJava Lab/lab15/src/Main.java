// Інтерфейс для команд
interface Command {
    void execute();
}

// Клас отримувача, який виконує фактичні дії
class BookOrder {
    private String bookTitle;

    public BookOrder(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void placeOrder() {
        System.out.println("Замовлення книги: " + bookTitle + " оформлено.");
    }

    public void cancelOrder() {
        System.out.println("Замовлення книги: " + bookTitle + " скасовано.");
    }

    public void checkStatus() {
        System.out.println("Перевірка статусу замовлення книги: " + bookTitle);
    }
}

// Конкретні команди
class PlaceOrderCommand implements Command {
    private BookOrder bookOrder;

    public PlaceOrderCommand(BookOrder bookOrder) {
        this.bookOrder = bookOrder;
    }

    @Override
    public void execute() {
        bookOrder.placeOrder();
    }
}

class CancelOrderCommand implements Command {
    private BookOrder bookOrder;

    public CancelOrderCommand(BookOrder bookOrder) {
        this.bookOrder = bookOrder;
    }

    @Override
    public void execute() {
        bookOrder.cancelOrder();
    }
}

class CheckStatusCommand implements Command {
    private BookOrder bookOrder;

    public CheckStatusCommand(BookOrder bookOrder) {
        this.bookOrder = bookOrder;
    }

    @Override
    public void execute() {
        bookOrder.checkStatus();
    }
}

// Invoker, який викликає команди
class Librarian {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

public class Main {
    public static void main(String[] args) {
        BookOrder bookOrder = new BookOrder("1984");

        Command placeOrder = new PlaceOrderCommand(bookOrder);
        Command cancelOrder = new CancelOrderCommand(bookOrder);
        Command checkStatus = new CheckStatusCommand(bookOrder);

        Librarian librarian = new Librarian();

        librarian.setCommand(placeOrder);
        librarian.executeCommand();

        librarian.setCommand(checkStatus);
        librarian.executeCommand();

        librarian.setCommand(cancelOrder);
        librarian.executeCommand();
    }
}
