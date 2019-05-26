import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ListOfBooks {

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
                Main.booksList.add(book);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        } catch (IOException e) {
            System.out.println("Nie znaleziono pliku");
        }
    }
}
