import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ReadFromFilesTest {

    @Test
    public void ReadFromFileBooksCsvTest() {

        List<Book> books = ListOfBooks.showListOfBooks();
        Assert.assertEquals("1;Clean Code;132350882;2008;T;1;3");

    }

    @Test
    public void ReadFromFileCategoriesCsvTest() {

    }

    @Test
    public void ReadFromFileAuthorsCsvTest() {

    }

}
