interface BookOrder {
    void processOrder();
}


class PhysicalBookOrder implements BookOrder {
    @Override
    public void processOrder() {
        System.out.println("Обробка замовлення на фізичну книгу.");
    }
}


class EbookOrder implements BookOrder {
    @Override
    public void processOrder() {
        System.out.println("Обробка замовлення на електронну книгу.");
    }
}


abstract class OrderFactory {
    public abstract BookOrder createOrder();
}


class PhysicalBookOrderFactory extends OrderFactory {
    @Override
    public BookOrder createOrder() {
        return new PhysicalBookOrder();
    }
}


class EbookOrderFactory extends OrderFactory {
    @Override
    public BookOrder createOrder() {
        return new EbookOrder();
    }
}

public class Main {
    public static void main(String[] args) {

        OrderFactory physicalBookFactory = new PhysicalBookOrderFactory();
        BookOrder physicalOrder = physicalBookFactory.createOrder();
        physicalOrder.processOrder();


        OrderFactory ebookFactory = new EbookOrderFactory();
        BookOrder ebookOrder = ebookFactory.createOrder();
        ebookOrder.processOrder();
    }
}
