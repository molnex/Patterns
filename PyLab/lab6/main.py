class Book:
    def __init__(self, title):
        self.title = title

    def get_title(self):
        return self.title

    def read(self):
        print(f"Читання книги: {self.title}")


class BookPool:
    def __init__(self, size):
        self.available_books = [Book(f"Книга {i}") for i in range(1, size + 1)]

    def acquire_book(self):
        if not self.available_books:
            print("Немає доступних книг у пулі.")
            return None
        return self.available_books.pop()

    def release_book(self, book):
        self.available_books.append(book)


if __name__ == "__main__":
    pool = BookPool(3)

    book1 = pool.acquire_book()
    if book1:
        book1.read()
        pool.release_book(book1)

    book2 = pool.acquire_book()
    if book2:
        book2.read()
        pool.release_book(book2)

    book3 = pool.acquire_book()
    if book3:
        book3.read()
        pool.release_book(book3)

    book4 = pool.acquire_book()  # Спроба отримати більше, ніж є в пулі
