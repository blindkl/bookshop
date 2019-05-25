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


    static void showListOfBooks() {

        try (FileReader fileReader = new FileReader("C://Users/blind/Desktop/kurs/bookshop/src/main/resources/books.csv")) {

            BufferedReader bufferReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferReader.readLine()) != null) {
                String[] split = line.split(";");
                String id = split[0];
                String title = split[1];
                String isbn = split[2];
                String year = split[3];
                Book book = new Book(Integer.parseInt(id), title, Integer.parseInt(isbn), Integer.parseInt(year));
                booksList.add(book);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        } catch (IOException e) {
            System.out.println("Nie znaleziono pliku");
        }
    }

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


        System.out.println("Podaj nowy rok wydania");
        int newNumber = Integer.parseInt(scanner.nextLine());

        for (Book book : booksList) {
            if (book.getYear() == number) {
                book.setYear(newNumber));
            }
        }

        System.out.println("Data wydania została zedytowana");

    }
//        System.out.println("Podaj tytuł książki, której datę wydania chcesz edytować:");
//        String editYear = "";
//        for (Book book : booksList) {
//            editYear == book.getTitle()
//        }
//        System.out.println(editYear);
//        int number = Integer.parseInt(scanner.nextLine());
//
//        System.out.println("Podaj nowy rok wydania");
//        String newNumber = scanner.nextLine();
//
//        for (Book book : booksList) {
//            if (book.getYear() == number) {
//                book.setYear(Integer.parseInt(newNumber));
//            }
//        }
//        System.out.println(booksList);


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

    static void categories() {

        try (FileReader fileReader = new FileReader("C://Users/blind/Desktop/kurs/bookshop/src/main/resources/categories.csv")) {

            BufferedReader bufferReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferReader.readLine()) != null) {
                String[] split = line.split(";");
                String id = split[0];
                String categoryName = split[1];
                String priority = split[2];
                Category category = new Category(Integer.parseInt(id), categoryName, Integer.parseInt(priority));
                categoriesList.add(category);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        } catch (IOException e) {
            System.out.println("Nie wczytano pliku");
        }
    }

    static void authors() {

        try (FileReader fileReader = new FileReader("C://Users/blind/Desktop/kurs/bookshop/src/main/resources/authors.csv")) {

            BufferedReader bufferReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferReader.readLine()) != null) {
                String[] split = line.split(";");
                String id = split[0];
                String name = split[1];
                String age = split[2];
                Author author = new Author(Integer.parseInt(id), name, Integer.parseInt(age));
                authorsList.add(author);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        } catch (IOException e) {
            System.out.println("Nie wczytano pliku");
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

    static void removeCategoryUsingId() {

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
                "\n 14. Wyjdź ");
    }

    static void menu() {
        showListOfBooks();
        authors();
        categories();
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
                    removeCategoryUsingId();
                    break;
                case 14:
                    exit();
                    break;
            }
        }
        while (numberOfOption != 14);
    }


    public static void main(String[] args) {

        menu();
    }
}
