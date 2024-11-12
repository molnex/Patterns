from abc import ABC, abstractmethod

class Command(ABC):
    @abstractmethod
    def execute(self):
        pass

class BookOrder:
    def __init__(self, book_title):
        self.book_title = book_title

    def place_order(self):
        print(f"Замовлення книги: {self.book_title} оформлено.")

    def cancel_order(self):
        print(f"Замовлення книги: {self.book_title} скасовано.")

    def check_status(self):
        print(f"Перевірка статусу замовлення книги: {self.book_title}")

class PlaceOrderCommand(Command):
    def __init__(self, book_order):
        self.book_order = book_order

    def execute(self):
        self.book_order.place_order()

class CancelOrderCommand(Command):
    def __init__(self, book_order):
        self.book_order = book_order

    def execute(self):
        self.book_order.cancel_order()

class CheckStatusCommand(Command):
    def __init__(self, book_order):
        self.book_order = book_order

    def execute(self):
        self.book_order.check_status()

class Librarian:
    def __init__(self):
        self.command = None

    def set_command(self, command):
        self.command = command

    def execute_command(self):
        if self.command:
            self.command.execute()

if __name__ == "__main__":
    book_order = BookOrder("1984")

    place_order = PlaceOrderCommand(book_order)
    cancel_order = CancelOrderCommand(book_order)
    check_status = CheckStatusCommand(book_order)

    librarian = Librarian()

    librarian.set_command(place_order)
    librarian.execute_command()

    librarian.set_command(check_status)
    librarian.execute_command()

    librarian.set_command(cancel_order)
    librarian.execute_command()
