class Book:
    def __init__(self, title, author, genre):
        self.title = title
        self.author = author
        self.genre = genre

    def get_description(self):
        return f"{self.title} by {self.author} [{self.genre}]"

class BookFactory:
    _books = {}

    @staticmethod
    def get_book(title, author, genre):
        key = (title, author, genre)
        if key not in BookFactory._books:
            BookFactory._books[key] = Book(title, author, genre)
            print(f"Створення нової книги: {title}")
        else:
            print(f"Повторне використання книги: {title}")
        return BookFactory._books[key]

class BookOrder:
    def __init__(self, book, user_id):
        self.book = book
        self.user_id = user_id

    def place_order(self):
        print(f"Замовлення книги: {self.book.get_description()} для користувача: {self.user_id}")

if __name__ == "__main__":
    book1 = BookFactory.get_book("1984", "George Orwell", "Dystopian")
    order1 = BookOrder(book1, "molnex")

    book2 = BookFactory.get_book("1984", "George Orwell", "Dystopian")
    order2 = BookOrder(book2, "vetalbka")

    order1.place_order()
    order2.place_order()
