import java.util.HashMap;
import java.util.Map;

class Book {
    private String title;
    private String author;
    private int copies;

    public Book(String title, String author, int copies) {
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "Название: '" + title + "', Автор: " + author + ", Копий: " + copies;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        HashMap<String, Book> library = new HashMap<>();

        library.put("978-2-820-52774-5 ", new Book("Ужас в Ред-Хуке", "Говард Лавкрафт", 12));
        library.put("978-5-389-06256-6", new Book("Преступление и наказание", "Федор Достоевский", 5));
        library.put("978-5-17-102043-9", new Book("Тёмная башня", "Стивен Кинг", 8));

        String searchIsbn = "978-5-389-06256-6";
        System.out.println("Поиск книги по ISBN " + searchIsbn + ":");
        if (library.containsKey(searchIsbn)) {
            Book foundBook = library.get(searchIsbn);
            System.out.println("Найдено -> " + foundBook);
        } else {
            System.out.println("Книга не найдена.");
        }

        library.remove("978-5-17-102043-9");
        System.out.println("\nКнига ISBN 978-5-17-102043-9 удалена");

        // Проверка результата
        System.out.println("\nТекущий список книг в библиотеке:");
        if (library.isEmpty()) {
            System.out.println("Библиотека пуста.");
        } else {

            for (Map.Entry<String, Book> entry : library.entrySet()) {
                System.out.println("ISBN: " + entry.getKey() + " | " + entry.getValue());
            }
        }
    }
}