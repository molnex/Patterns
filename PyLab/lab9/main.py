from abc import ABC, abstractmethod

class LibraryComponent(ABC):
    @abstractmethod
    def show_details(self):
        pass

class Book(LibraryComponent):
    def __init__(self, title):
        self.title = title

    def show_details(self):
        print(f"Книга: {self.title}")

class BookCategory(LibraryComponent):
    def __init__(self, name):
        self.name = name
        self.components = []

    def add_component(self, component):
        self.components.append(component)

    def remove_component(self, component):
        self.components.remove(component)

    def show_details(self):
        print(f"Категорія: {self.name}")
        for component in self.components:
            component.show_details()

if __name__ == "__main__":
    fiction = BookCategory("Художня література")
    mystery = BookCategory("Детективи")
    sci_fi = BookCategory("Наукова фантастика")

    book1 = Book("Дюна")
    book2 = Book("1984")
    book3 = Book("Шерлок Холмс")

    fiction.add_component(book1)
    sci_fi.add_component(book2)
    mystery.add_component(book3)

    fiction.add_component(mystery)
    fiction.add_component(sci_fi)

    fiction.show_details()
