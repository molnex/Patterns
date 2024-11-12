// Інтерфейс бібліотечної системи замовлень
interface LibraryOrder {
    void placeOrder(String bookTitle);
}

// Клас зовнішнього сервісу для замовлення книг
class ExternalBookService {
    public void orderBook(String title) {
        System.out.println("Замовлення книги через зовнішній сервіс: " + title);
    }
}

// Адаптер, що дозволяє інтегрувати зовнішній сервіс із бібліотечною системою
class BookOrderAdapter implements LibraryOrder {
    private ExternalBookService externalBookService;

    public BookOrderAdapter(ExternalBookService externalBookService) {
        this.externalBookService = externalBookService;
    }

    @Override
    public void placeOrder(String bookTitle) {
        externalBookService.orderBook(bookTitle);
    }
}

public class Main {
    public static void main(String[] args) {
        ExternalBookService externalService = new ExternalBookService();
        LibraryOrder libraryOrder = new BookOrderAdapter(externalService);

        libraryOrder.placeOrder("Великий Гетсбі");
    }
}
