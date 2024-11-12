from abc import ABC, abstractmethod

class BookOrder(ABC):
    @abstractmethod
    def place_order(self, book_title):
        pass

class RealBookOrder(BookOrder):
    def __init__(self, user_id):
        self.user_id = user_id

    def place_order(self, book_title):
        print(f"Замовлення на книгу: {book_title} успішно оформлено для користувача: {self.user_id}")

class BookOrderProxy(BookOrder):
    def __init__(self, user_id, has_access):
        self.user_id = user_id
        self.has_access = has_access
        self.real_book_order = None

    def place_order(self, book_title):
        if self.has_access:
            if self.real_book_order is None:
                self.real_book_order = RealBookOrder(self.user_id)
            self.real_book_order.place_order(book_title)
        else:
            print(f"Користувач {self.user_id} не має доступу до замовлення книги.")

if __name__ == "__main__":
    user_with_access = BookOrderProxy("molnex", True)
    user_with_access.place_order("1984")

    user_without_access = BookOrderProxy("vetalbka", False)
    user_without_access.place_order("Animal Farm")
