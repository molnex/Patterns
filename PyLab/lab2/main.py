import copy

class BookOrder:
    def __init__(self, book_title, customer_name):
        self.book_title = book_title
        self.customer_name = customer_name

    # Метод для клонування об'єкта
    def clone(self):
        return copy.deepcopy(self)

    def set_customer_name(self, customer_name):
        self.customer_name = customer_name

    def __str__(self):
        return f'Замовлення книги: {self.book_title} для клієнта {self.customer_name}'

# Демонстрація використання патерну Prototype
if __name__ == "__main__":
    # Створення початкового замовлення
    original_order = BookOrder("Гаррі Поттер і філософський камінь", "Василь")

    # Копіювання початкового замовлення для іншого клієнта
    copied_order = original_order.clone()
    copied_order.set_customer_name("Віталій")

    # Виведення замовлень
    print(original_order)
    print(copied_order)
