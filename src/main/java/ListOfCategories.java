import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListOfCategories {

    static List<Category> categories() {
        List<Category> categories = new ArrayList<>();
        try (FileReader fileReader = new FileReader("C://Users/blind/Desktop/kurs/bookshop/src/main/resources/categories.csv")) {

            BufferedReader bufferReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferReader.readLine()) != null) {
                String[] split = line.split(";");
                String id = split[0];
                String categoryName = split[1];
                String priority = split[2];
                Category category = new Category(Integer.parseInt(id), categoryName, Integer.parseInt(priority));
                Main.categoriesList.add(category);
                categories.add(category);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        } catch (IOException e) {
            System.out.println("Nie wczytano pliku");
        }
        return categories;
    }
}
