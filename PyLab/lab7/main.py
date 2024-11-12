from abc import ABC, abstractmethod

class LibraryOrder(ABC):
    @abstractmethod
    def place_order(self, book_title):
        pass

class ExternalBookService:
    def order_book(self, title):
        print(f"Замовлення книги через зовнішній сервіс: {title}")

class BookOrderAdapter(LibraryOrder):
    def __init__(self, external_service):
        self.external_service = external_service

    def place_order(self, book_title):
        self.external_service.order_book(book_title)

if __name__ == "__main__":
    external_service = ExternalBookService()
    library_order = BookOrderAdapter(external_service)

    library_order.place_order("Великий Гетсбі")
