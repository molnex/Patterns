class BookOrder {
    private String bookTitle;
    private String customerName;
    private String deliveryAddress;
    private boolean isGiftWrapped;
    private boolean isExpressDelivery;

    public static class Builder {
        private String bookTitle;
        private String customerName;
        private String deliveryAddress;
        private boolean isGiftWrapped;
        private boolean isExpressDelivery;

        public Builder(String bookTitle, String customerName) {
            this.bookTitle = bookTitle;
            this.customerName = customerName;
        }

        public Builder setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Builder setGiftWrapped(boolean isGiftWrapped) {
            this.isGiftWrapped = isGiftWrapped;
            return this;
        }

        public Builder setExpressDelivery(boolean isExpressDelivery) {
            this.isExpressDelivery = isExpressDelivery;
            return this;
        }

        public BookOrder build() {
            return new BookOrder(this);
        }
    }

    private BookOrder(Builder builder) {
        this.bookTitle = builder.bookTitle;
        this.customerName = builder.customerName;
        this.deliveryAddress = builder.deliveryAddress;
        this.isGiftWrapped = builder.isGiftWrapped;
        this.isExpressDelivery = builder.isExpressDelivery;
    }

    public void processOrder() {
        System.out.println("Обробка замовлення на книгу: " + bookTitle);
        System.out.println("Клієнт: " + customerName);
        if (deliveryAddress != null) {
            System.out.println("Адреса доставки: " + deliveryAddress);
        }
        if (isGiftWrapped) {
            System.out.println("Замовлення буде загорнуте в подарункову упаковку.");
        }
        if (isExpressDelivery) {
            System.out.println("Швидка доставка замовлення.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BookOrder order = new BookOrder.Builder("Гаррі Поттер", "Сабіна")
                .setDeliveryAddress("Вул. Ентузіастів, 15")
                .setGiftWrapped(true)
                .setExpressDelivery(true)
                .build();
        order.processOrder();
    }
}
