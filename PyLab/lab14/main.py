class OrderHandler:
    def __init__(self):
        self.next_handler = None

    def set_next_handler(self, handler):
        self.next_handler = handler

    def handle_request(self, request):
        if self.next_handler:
            self.next_handler.handle_request(request)

class BookOrderRequest:
    def __init__(self, book_title, member_id, amount):
        self.book_title = book_title
        self.member_id = member_id
        self.amount = amount

class InventoryHandler(OrderHandler):
    def handle_request(self, request):
        print(f"Перевірка наявності книги: {request.book_title}")
        super().handle_request(request)

class MembershipHandler(OrderHandler):
    def handle_request(self, request):
        print(f"Перевірка членства для користувача: {request.member_id}")
        super().handle_request(request)

class PaymentHandler(OrderHandler):
    def handle_request(self, request):
        print(f"Обробка оплати на суму: ${request.amount}")
        print(f"Замовлення на книгу {request.book_title} оформлено.")

if __name__ == "__main__":

    inventory_handler = InventoryHandler()
    membership_handler = MembershipHandler()
    payment_handler = PaymentHandler()

    inventory_handler.set_next_handler(membership_handler)
    membership_handler.set_next_handler(payment_handler)


    request = BookOrderRequest("1984", "molnex", 15.0)


    inventory_handler.handle_request(request)
