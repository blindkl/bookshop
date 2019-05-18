import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BookFunctionsTest {

    private List<Book> bookList = new ArrayList<>();

    @Before
    public void init() {
        Book book1 = new Book(1, "Clean Code", 132350882, 2008);
        Book book2 = new Book(2, "Effective Java (3rd Edition)", 134685997, 2018);
        Book book3 = new Book(3, "Test Driven Development: By Example", 321146530, 2001);
        Book book4 = new Book(4, "Patterns of Enterprise Application Architecture", 321127420, 2002);
        Book book5 = new Book(5, "Head First Design Patterns", 596007124, 2004);
        Book book6 = new Book(6, "Clean Architecture", 134494164, 2017);

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);
    }

    private BookFunctions bookFunctions = new BookFunctions();

    @Test
    public void test1() {
        Book book = bookFunctions.searchByIsbnStream(134494164, bookList);
        Assert.assertEquals("Clean Architecture", book.getTitle());
    }

    @Test
    public void test2() {
        List<Book> twoLastBooks = bookFunctions.getTwoLastBooksStream(bookList);
        Book preLastBook = twoLastBooks.get(0);
        Book lastBook = twoLastBooks.get(1);
        Assert.assertEquals("Head First Design Patterns", preLastBook.getTitle());
        Assert.assertEquals("Clean Architecture", lastBook.getTitle());
    }

    @Test
    public void test3() {
        Book earliestBook = bookFunctions.getEarliestPublishedStream(2001, bookList);
        Assert.assertEquals("Test Driven Development: By Example", earliestBook.getYear());
    }

    @Test
    public void test4() {
        Book lastBook = bookFunctions.getLastPublishedStream(2018, bookList);
        Assert.assertEquals("Effective Java (3rd Edition)", lastBook.getYear());
    }

}
