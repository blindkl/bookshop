import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static void showListOfBooks() {
        List<Book> bookList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("C://Users/blind/Desktop/kurs/bookshop/src/main/resources/books.csv");

            BufferedReader bufferReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferReader.readLine()) != null) {
                System.out.println(line);
                String[] split = line.split(";");
                String id = split[0];
                String title = split[1];
                String isbn = split[2];
                String year = split[3];
                Book book = new Book(Integer.parseInt(id), title, Integer.parseInt(isbn), Integer.parseInt(year));
                bookList.add(book);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void addNewBook() {
        System.out.println("Podaj tytuł książki");
        String title = scanner.nextLine();
        System.out.println("Podaj ISBN książki");
        int isbn = Integer.parseInt(scanner.nextLine());
        System.out.println("Podaj rok wydania książki");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Nowa książka została dodana");
    }

    static void deleteBookTitle() {
        System.out.println("Podaj tytuł książki");
        String title = scanner.nextLine();
        System.out.println("Książka została usunięta");
    }

    static void editYearOfBook() {
        System.out.println("Edycja roku wydania książki");
    }

    static void saveListOfBooksToCsvFile() {
        System.out.println("Zapisz do pliku csv");
            }

    static void exit() {
        System.out.println("Wyjdź");
    }

    static void showMenu() {
        System.out.print("Menu:\n 1. Wyświetl listę książek \n 2. Dodanie nowej książki \n 3. Usunięcie książki po nazwie \n 4. Edycja roku wydania książki \n 5. Zapisz listę książek do pliku csv\n 6. Wyjdź ");
    }

    static void menu() {
        int numberOfOption;
        do {
            showMenu();
            numberOfOption = Integer.parseInt(scanner.nextLine());
            switch (numberOfOption) {
                case 1:
                    showListOfBooks();
                    break;
                case 2:
                    addNewBook();
                    break;
                case 3:
                    deleteBookTitle();
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
