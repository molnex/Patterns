class BookOrder:
    def __init__(self, book_title, customer_name, delivery_address=None, is_gift_wrapped=False, is_express_delivery=False):
        self.book_title = book_title
        self.customer_name = customer_name
        self.delivery_address = delivery_address
        self.is_gift_wrapped = is_gift_wrapped
        self.is_express_delivery = is_express_delivery

    def process_order(self):
        print(f"Обробка замовлення на книгу: {self.book_title}")
        print(f"Клієнт: {self.customer_name}")
        if self.delivery_address:
            print(f"Адреса доставки: {self.delivery_address}")
        if self.is_gift_wrapped:
            print("Замовлення буде загорнуте в подарункову упаковку.")
        if self.is_express_delivery:
            print("Швидка доставка замовлення.")

class BookOrderBuilder:
    def __init__(self, book_title, customer_name):
        self.book_title = book_title
        self.customer_name = customer_name
        self.delivery_address = None
        self.is_gift_wrapped = False
        self.is_express_delivery = False

    def set_delivery_address(self, delivery_address):
        self.delivery_address = delivery_address
        return self

    def set_gift_wrapped(self, is_gift_wrapped):
        self.is_gift_wrapped = is_gift_wrapped
        return self

    def set_express_delivery(self, is_express_delivery):
        self.is_express_delivery = is_express_delivery
        return self

    def build(self):
        return BookOrder(self.book_title, self.customer_name, self.delivery_address, self.is_gift_wrapped, self.is_express_delivery)

if __name__ == "__main__":
    order = (BookOrderBuilder("Гаррі Поттер", "Сабіна")
             .set_delivery_address("Вул. Ентузіастів, 15")
             .set_gift_wrapped(True)
             .set_express_delivery(True)
             .build())
    order.process_order()
