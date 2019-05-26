import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Book> booksList = new ArrayList<>();
    static List<Category> categoriesList = new ArrayList<>();
    static List<Author> authorsList = new ArrayList<>();
    static BookFunctions bookFunctions = new BookFunctions();


    static void addNewBook() {
        System.out.println("Podaj tytuł książki");
        String title = scanner.nextLine();
        System.out.println("Podaj ISBN książki");
        int isbn = Integer.parseInt(scanner.nextLine());
        System.out.println("Podaj rok wydania książki");
        int year = Integer.parseInt(scanner.nextLine());

        booksList.add(new Book(booksList.size() + 1, title, isbn, year));
        System.out.println("Nowa książka została dodana");
    }

    static void removeBookTitle() {
        System.out.println("Podaj tytuł książki");
        String title = scanner.nextLine();

        Book bookToRemove = null;

        for (Book book : booksList) {
            if (book.getTitle().equals(title)) {
                bookToRemove = book;
            }
        }

        booksList.remove(bookToRemove);
        System.out.println("Książka została usunięta");
    }

    static void editYearOfBook() {
        System.out.println("Podaj tytuł książki, której datę wydania chcesz edytować");
        String title = scanner.nextLine();

        Book bookToYearEdit = null;

        for (Book book : booksList) {
            if (book.getTitle().equals(title)) {
                bookToYearEdit = book;
            }
        }

        System.out.println(bookToYearEdit);
        System.out.println("Podaj obecny rok wydania");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.println("Podaj nowy rok wydania");
        int newYear = Integer.parseInt(scanner.nextLine());

        for (Book book : booksList) {
            if (book.getYear() == year) {
                book.setYear(newYear);
            }
        }

        System.out.println("Data wydania została zedytowana");

    }

    static void saveListOfBooksToCsvFile() {
        try (PrintWriter writer = new PrintWriter(new File("C://Users/blind/Desktop/kurs/bookshop/src/main/resources/bookslist.csv"))) {

            for (Book book : booksList) {
                StringBuilder build = new StringBuilder();
                build.append(book.getId());
                build.append(';');
                build.append(book.getTitle());
                build.append(';');
                build.append(book.getIsbn());
                build.append(';');
                build.append(book.getYear());
                build.append('\n');
                writer.write(build.toString());
            }
            System.out.println("Plik *bookslist.csv* został zapisany");

        } catch (FileNotFoundException e) {
            System.out.println("Plik nie został poprawnie zapisany");
        }
    }

    static void sortOfBooks() {
        System.out.println(bookFunctions.getSortedBooksYearStream(booksList));
    }

    static void reverseSortOfBooks() {
        System.out.println(bookFunctions.getReverseSortedBooksYearStream(booksList));
    }

    static void booksAfter2007() {
        System.out.println(bookFunctions.getBooksPublishedAfter2007Stream(booksList));
    }

    static void showAllCategories() {

    }

    static void showAllAuthors() {

    }

    static void removeCategoryById() {
        System.out.println("Podaj ID kategorii");
        Integer id = Integer.valueOf(scanner.nextLine());

        Category categoryToRemove = null;

        for (Category category : categoriesList) {
            if (category.getId().equals(id)) {
                categoryToRemove = category;
            }
        }

        categoriesList.remove(categoryToRemove);
        System.out.println("Kategoria została usunięta");
    }

    static List<Book> showAllBooksByAuthor() {

        System.out.println("Wybierz autora:");
        String authorToShow = "";

        for (Author author : authorsList) {
            authorToShow += author.getId() + ". " + author.getName() + "\n";
        }
        System.out.println(authorToShow);
        int authorNumber = Integer.parseInt(scanner.nextLine());

        List<Book> allBooksByAuthor = new ArrayList<>();
        for (Book book : booksList) {
            if (authorNumber == book.getId()) {
                allBooksByAuthor.add(book);
            }
        }
        System.out.println(allBooksByAuthor);
        return allBooksByAuthor;

    }

    static void saveListOfCategories() {
        try (PrintWriter writer = new PrintWriter(new File("C://Users/blind/Desktop/kurs/bookshop/src/main/resources/categorieslist.csv"))) {

            for (Category category : categoriesList) {
                StringBuilder build = new StringBuilder();
                build.append(category.getId());
                build.append(';');
                build.append(category.getCategoryName());
                build.append(';');
                build.append(category.getPriority());
                build.append('\n');
                writer.write(build.toString());
            }
            System.out.println("Plik *categorieslist.csv* został zapisany");

        } catch (FileNotFoundException e) {
            System.out.println("Plik nie został poprawnie zapisany");
        }

    }

    static void save() {

    }


    static void exit() {
        System.out.println("Wyjdź");
    }

    static void showMenu() {
        System.out.print("Menu:\n 1. Wyświetl listę książek " +
                "\n 2. Dodanie nowej książki " +
                "\n 3. Usunięcie książki po nazwie " +
                "\n 4. Edycja roku wydania książki " +
                "\n 5. Zapisz listę książek do pliku csv" +
                "\n 6. Wyświetl listę kategorii" +
                "\n 7. Wyświetl listę autorów" +
                "\n 8. Sortowanie po roku wydania rosnąco" +
                "\n 9. Sortowanie po roku wydania malejąco" +
                "\n 10. Liczba książek wydanych po 2007 roku" +
                "\n 11. Wyświetl wszystkie kategorie" +
                "\n 12. Wyświetl wszystkich autorów" +
                "\n 13. Usunięcie kategorii po identyfikatorze" +
                "\n 14. Wyświetlanie książek po autorze" +
                "\n 15. Zapisz listę kategorii" +
                "\n 16. Zapisz stan" +
                "\n 17. Wyjdź ");
    }

    static void menu() {
        ListOfBooks.showListOfBooks();
        ListOfAuthors.authors();
        ListOfCategories.categories();
        int numberOfOption;
        do {
            showMenu();
            numberOfOption = Integer.parseInt(scanner.nextLine());
            switch (numberOfOption) {
                case 1:
                    System.out.println(booksList);
                    break;
                case 2:
                    addNewBook();
                    break;
                case 3:
                    removeBookTitle();
                    break;
                case 4:
                    editYearOfBook();
                    break;
                case 5:
                    saveListOfBooksToCsvFile();
                    break;
                case 6:
                    System.out.println(categoriesList);
                    break;
                case 7:
                    System.out.println(authorsList);
                    break;
                case 8:
                    sortOfBooks();
                    break;
                case 9:
                    reverseSortOfBooks();
                    break;
                case 10:
                    booksAfter2007();
                    break;
                case 11:
                    showAllCategories();
                    break;
                case 12:
                    showAllAuthors();
                    break;
                case 13:
                    removeCategoryById();
                    break;
                case 14:
                    showAllBooksByAuthor();
                    break;
                case 15:
                    saveListOfCategories();
                case 16:
                    save();
                    break;
                case 17:
                    exit();
                    break;
            }
        }
        while (numberOfOption != 17);
    }


    public static void main(String[] args) {

        menu();
    }
}
