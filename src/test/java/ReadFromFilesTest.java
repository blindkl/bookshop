import org.junit.Test;

import java.io.*;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ReadFromFilesTest {

    @Test
    public void ReadFromFileBooksCsvTest() {

        try (FileReader fileReader = new FileReader("C://Users/blind/Desktop/kurs/bookshop/src/test/resources/books.csv")) {

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

    @Test
    public void ReadFromFileCategoriesCsvTest() {

    }

    @Test
    public void ReadFromFileAuthorsCsvTest() {

    }

}
