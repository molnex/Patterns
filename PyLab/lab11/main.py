class InventorySystem:
    def check_availability(self, book_title):
        print(f"Перевірка наявності книги: {book_title}")
        return True  # У спрощеній версії завжди повертаємо, що книга доступна

class MembershipSystem:
    def validate_membership(self, member_id):
        print(f"Перевірка членства для користувача: {member_id}")
        return True  # Спрощена валідація

class PaymentSystem:
    def process_payment(self, member_id, amount):
        print(f"Обробка оплати для користувача {member_id} на суму: ${amount}")
        return True  # Спрощена версія, оплата завжди успішна

class BookOrderFacade:
    def __init__(self):
        self.inventory_system = InventorySystem()
        self.membership_system = MembershipSystem()
        self.payment_system = PaymentSystem()

    def place_order(self, book_title, member_id, amount):
        print("=== Оформлення замовлення на книгу ===")
        if (self.inventory_system.check_availability(book_title) and
            self.membership_system.validate_membership(member_id) and
            self.payment_system.process_payment(member_id, amount)):
            print(f"Замовлення успішно оформлено для книги: {book_title}")
        else:
            print("Помилка при оформленні замовлення.")

if __name__ == "__main__":
    facade = BookOrderFacade()
    facade.place_order("1984", "molnex", 15.0)
