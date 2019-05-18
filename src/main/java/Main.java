import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Book> booksList = new ArrayList<>();

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
            e.printStackTrace();
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
//    year
//    new year
//        booksList.set()

        System.out.println("Rok wydania książki został zedytowany");
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

    static void exit() {
        System.out.println("Wyjdź");
    }

    static void showMenu() {
        System.out.print("Menu:\n 1. Wyświetl listę książek " +
                "\n 2. Dodanie nowej książki " +
                "\n 3. Usunięcie książki po nazwie " +
                "\n 4. Edycja roku wydania książki " +
                "\n 5. Zapisz listę książek do pliku csv" +
                "\n 6. Wyjdź ");
    }

    static void menu() {
        showListOfBooks();
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
                    exit();
                    break;
            }
        }
        while (numberOfOption != 6);
    }

    public static void main(String[] args) {

        menu();
    }
}
