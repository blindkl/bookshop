import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListOfAuthors {

    static List<Author> authors() {
        List<Author> authors = new ArrayList<>();
        try (FileReader fileReader = new FileReader("C://Users/blind/Desktop/kurs/bookshop/src/main/resources/authors.csv")) {

            BufferedReader bufferReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferReader.readLine()) != null) {
                String[] split = line.split(";");
                String id = split[0];
                String name = split[1];
                String age = split[2];
                Author author = new Author(Integer.parseInt(id), name, Integer.parseInt(age));
                Main.authorsList.add(author);
                authors.add(author);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        } catch (IOException e) {
            System.out.println("Nie wczytano pliku");
        }
        return authors;
    }

}
