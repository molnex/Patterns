// Абстракція для замовлення книги
abstract class BookOrder {
    protected Membership membership;

    public BookOrder(Membership membership) {
        this.membership = membership;
    }

    public abstract void placeOrder(String bookTitle);
}

// Конкретне замовлення фізичної книги
class PhysicalBookOrder extends BookOrder {
    public PhysicalBookOrder(Membership membership) {
        super(membership);
    }

    @Override
    public void placeOrder(String bookTitle) {
        System.out.println("Замовлення фізичної книги: " + bookTitle);
        membership.activate();
    }
}

// Конкретне замовлення електронної книги
class EbookOrder extends BookOrder {
    public EbookOrder(Membership membership) {
        super(membership);
    }

    @Override
    public void placeOrder(String bookTitle) {
        System.out.println("Замовлення електронної книги: " + bookTitle);
        membership.activate();
    }
}


interface Membership {
    void activate();
}


class BasicMembership implements Membership {
    @Override
    public void activate() {
        System.out.println("Активовано базове членство.");
    }
}


class PremiumMembership implements Membership {
    @Override
    public void activate() {
        System.out.println("Активовано преміум членство.");
    }
}

public class Main {
    public static void main(String[] args) {
        BookOrder physicalOrderWithBasic = new PhysicalBookOrder(new BasicMembership());
        physicalOrderWithBasic.placeOrder("Великий Гетсбі");

        BookOrder ebookOrderWithPremium = new EbookOrder(new PremiumMembership());
        ebookOrderWithPremium.placeOrder("1984");
    }
}
