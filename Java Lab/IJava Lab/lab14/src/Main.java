abstract class OrderHandler {
    protected OrderHandler nextHandler;

    public void setNextHandler(OrderHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(BookOrderRequest request);
}


class BookOrderRequest {
    private String bookTitle;
    private String memberId;
    private double amount;

    public BookOrderRequest(String bookTitle, String memberId, double amount) {
        this.bookTitle = bookTitle;
        this.memberId = memberId;
        this.amount = amount;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getMemberId() {
        return memberId;
    }

    public double getAmount() {
        return amount;
    }
}


class InventoryHandler extends OrderHandler {
    @Override
    public void handleRequest(BookOrderRequest request) {
        System.out.println("Перевірка наявності книги: " + request.getBookTitle());
        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}


class MembershipHandler extends OrderHandler {
    @Override
    public void handleRequest(BookOrderRequest request) {
        System.out.println("Перевірка членства для користувача: " + request.getMemberId());
        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}


class PaymentHandler extends OrderHandler {
    @Override
    public void handleRequest(BookOrderRequest request) {
        System.out.println("Обробка оплати на суму: $" + request.getAmount());
        System.out.println("Замовлення на книгу " + request.getBookTitle() + " оформлено.");
    }
}

public class Main {
    public static void main(String[] args) {

        OrderHandler inventoryHandler = new InventoryHandler();
        OrderHandler membershipHandler = new MembershipHandler();
        OrderHandler paymentHandler = new PaymentHandler();

        inventoryHandler.setNextHandler(membershipHandler);
        membershipHandler.setNextHandler(paymentHandler);


        BookOrderRequest request = new BookOrderRequest("1984", "molnex", 15.0);


        inventoryHandler.handleRequest(request);
    }
}
