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

class Membership(ABC):
    @abstractmethod
    def activate_membership(self):
        pass

class BasicMembership(Membership):
    def activate_membership(self):
        print("Активація базового членства.")

class PremiumMembership(Membership):
    def activate_membership(self):
        print("Активація преміум членства.")

class LibraryFactory(ABC):
    @abstractmethod
    def create_book_order(self):
        pass

    @abstractmethod
    def create_membership(self):
        pass

class PhysicalLibraryFactory(LibraryFactory):
    def create_book_order(self):
        return PhysicalBookOrder()

    def create_membership(self):
        return BasicMembership()

class DigitalLibraryFactory(LibraryFactory):
    def create_book_order(self):
        return EbookOrder()

    def create_membership(self):
        return PremiumMembership()

if __name__ == "__main__":
    physical_factory = PhysicalLibraryFactory()
    physical_order = physical_factory.create_book_order()
    basic_membership = physical_factory.create_membership()
    physical_order.process_order()
    basic_membership.activate_membership()

    digital_factory = DigitalLibraryFactory()
    digital_order = digital_factory.create_book_order()
    premium_membership = digital_factory.create_membership()
    digital_order.process_order()
    premium_membership.activate_membership()
