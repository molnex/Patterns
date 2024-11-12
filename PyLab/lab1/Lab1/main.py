class LibraryOrderSystem:
    # Приватна змінна класу для збереження єдиного екземпляра
    _instance = None

    # Приватний конструктор
    def __init__(self):
        if LibraryOrderSystem._instance is not None:
            raise Exception("Цей клас є Singleton!")
        else:
            LibraryOrderSystem._instance = self
            print("Система замовлення книг ініціалізована.")

    # Метод для отримання єдиного екземпляра класу
    @staticmethod
    def get_instance():
        if LibraryOrderSystem._instance is None:
            LibraryOrderSystem()
        return LibraryOrderSystem._instance

    # Метод для створення замовлення на книгу
    def create_order(self, book_title):
        print(f'Замовлення на книгу "{book_title}" створене.')

# Демонстрація роботи Singleton
if __name__ == "__main__":
    # Отримуємо єдиний екземпляр системи замовлення книг
    order_system = LibraryOrderSystem.get_instance()
    order_system.create_order("Гаррі Поттер і філософський камінь")

    # Перевірка, що при повторному зверненні отримується той же екземпляр
    another_order_system = LibraryOrderSystem.get_instance()
    another_order_system.create_order("Володар Перснів")

    # Порівняння екземплярів
    print("Один і той самий екземпляр:", order_system is another_order_system)
