import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ReadFromFilesTest {

    @Test
    public void ReadFromFileBooksCsvTest() {

        List<Book> books = ListOfBooks.showListOfBooks();
        C://Users/blind/Desktop/kurs/bookshop/src/test/resources/bookstest.csv
        Assert.assertEquals("Clean Code", books.get(0).getTitle());
        Assert.assertEquals("132350882", books.get(0).getIsbn());
        Assert.assertEquals(2008, books.get(0).getYear());
    }

    @Test
    public void ReadFromFileCategoriesCsvTest() {

    }

    @Test
    public void ReadFromFileAuthorsCsvTest() {

    }

}
