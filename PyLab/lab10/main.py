from abc import ABC, abstractmethod

class BookOrder(ABC):
    @abstractmethod
    def get_description(self):
        pass

    @abstractmethod
    def get_cost(self):
        pass

class BasicBookOrder(BookOrder):
    def get_description(self):
        return "Замовлення книги"

    def get_cost(self):
        return 10.0

class BookOrderDecorator(BookOrder):
    def __init__(self, book_order):
        self.book_order = book_order

    def get_description(self):
        return self.book_order.get_description()

    def get_cost(self):
        return self.book_order.get_cost()

class WrappedBookOrder(BookOrderDecorator):
    def get_description(self):
        return super().get_description() + ", з обгорткою"

    def get_cost(self):
        return super().get_cost() + 2.0

class ExpressDeliveryOrder(BookOrderDecorator):
    def get_description(self):
        return super().get_description() + ", з експрес-доставкою"

    def get_cost(self):
        return super().get_cost() + 5.0

if __name__ == "__main__":
    order = BasicBookOrder()
    order = WrappedBookOrder(order)
    order = ExpressDeliveryOrder(order)

    print("Опис:", order.get_description())
    print("Загальна вартість: $", order.get_cost())
