from abc import ABC, abstractmethod

class BookOrder(ABC):
    def __init__(self, membership):
        self.membership = membership

    @abstractmethod
    def place_order(self, book_title):
        pass

class PhysicalBookOrder(BookOrder):
    def place_order(self, book_title):
        print(f"Замовлення фізичної книги: {book_title}")
        self.membership.activate()

class EbookOrder(BookOrder):
    def place_order(self, book_title):
        print(f"Замовлення електронної книги: {book_title}")
        self.membership.activate()

class Membership(ABC):
    @abstractmethod
    def activate(self):
        pass

class BasicMembership(Membership):
    def activate(self):
        print("Активовано базове членство.")

class PremiumMembership(Membership):
    def activate(self):
        print("Активовано преміум членство.")

if __name__ == "__main__":
    physical_order_with_basic = PhysicalBookOrder(BasicMembership())
    physical_order_with_basic.place_order("Великий Гетсбі")

    ebook_order_with_premium = EbookOrder(PremiumMembership())
    ebook_order_with_premium.place_order("1984")
