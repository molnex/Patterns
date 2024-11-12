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

interface Membership {
    void activateMembership();
}

class BasicMembership implements Membership {
    @Override
    public void activateMembership() {
        System.out.println("Активація базового членства.");
    }
}

class PremiumMembership implements Membership {
    @Override
    public void activateMembership() {
        System.out.println("Активація преміум членства.");
    }
}

interface LibraryFactory {
    BookOrder createBookOrder();
    Membership createMembership();
}

class PhysicalLibraryFactory implements LibraryFactory {
    @Override
    public BookOrder createBookOrder() {
        return new PhysicalBookOrder();
    }

    @Override
    public Membership createMembership() {
        return new BasicMembership();
    }
}

class DigitalLibraryFactory implements LibraryFactory {
    @Override
    public BookOrder createBookOrder() {
        return new EbookOrder();
    }

    @Override
    public Membership createMembership() {
        return new PremiumMembership();
    }
}

public class Main {
    public static void main(String[] args) {
        LibraryFactory physicalFactory = new PhysicalLibraryFactory();
        BookOrder physicalOrder = physicalFactory.createBookOrder();
        Membership basicMembership = physicalFactory.createMembership();
        physicalOrder.processOrder();
        basicMembership.activateMembership();

        LibraryFactory digitalFactory = new DigitalLibraryFactory();
        BookOrder digitalOrder = digitalFactory.createBookOrder();
        Membership premiumMembership = digitalFactory.createMembership();
        digitalOrder.processOrder();
        premiumMembership.activateMembership();
    }
}
