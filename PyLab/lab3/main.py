from abc import ABC, abstractmethod


class BookOrder(ABC):
    @abstractmethod
    def process_order(self):
        pass


class PhysicalBookOrder(BookOrder):
    def process_order(self):
        print("Обробка замовлення на фізичну книгу.")


class EbookOrder(BookOrder):
    def process_order(self):
        print("Обробка замовлення на електронну книгу.")


class OrderFactory(ABC):
    @abstractmethod
    def create_order(self):
        pass


class PhysicalBookOrderFactory(OrderFactory):
    def create_order(self):
        return PhysicalBookOrder()


class EbookOrderFactory(OrderFactory):
    def create_order(self):
        return EbookOrder()

if __name__ == "__main__":

    physical_book_factory = PhysicalBookOrderFactory()
    physical_order = physical_book_factory.create_order()
    physical_order.process_order()


    ebook_factory = EbookOrderFactory()
    ebook_order = ebook_factory.create_order()
    ebook_order.process_order()
