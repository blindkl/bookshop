import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public void test1a() {
        Book book = bookFunctions.searchByIsbn(134494164, bookList);
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
    public void test2a() {
        List<Book> twoLastBooks = bookFunctions.getTwoLast(bookList);
        Book preLastBook = twoLastBooks.get(0);
        Book lastBook = twoLastBooks.get(1);
        Assert.assertEquals("Head First Design Patterns", preLastBook.getTitle());
        Assert.assertEquals("Clean Architecture", lastBook.getTitle());
    }

    @Test
    public void test3() {
        Book earliestBook = bookFunctions.getEarliestPublishedStream(2001, bookList);
        Assert.assertEquals("Test Driven Development: By Example", earliestBook.getTitle());
    }

    @Test
    public void test3Optional() {
        Optional<Book> earliestBook = bookFunctions.getEarliestPublishedStream2(2001, new ArrayList<>());
        Assert.assertEquals(false, earliestBook.isPresent());
    }

    @Test
    public void test3a() {
        Book earliestBook = bookFunctions.getEarliestPublished(2001, bookList);
        Assert.assertEquals("Test Driven Development: By Example", earliestBook.getTitle());
    }

    @Test
    public void test4() {
        Book lastBook = bookFunctions.getLastPublishedStream(2018, bookList);
        Assert.assertEquals("Effective Java (3rd Edition)", lastBook.getTitle());
    }

    @Test
    public void test4Optional() {
        Optional<Book> lastBook = bookFunctions.getLastPublishedStream2(2018, new ArrayList<>());
        Assert.assertEquals(false, lastBook.isPresent());
    }

    @Test
    public void test4a() {
        Book lastBook = bookFunctions.getLastPublished(2018, bookList);
        Assert.assertEquals("Effective Java (3rd Edition)", lastBook.getTitle());
    }

    @Test
    public void test5() {
        int yearsSum = bookFunctions.sumAllYearsStream(bookList);
        Assert.assertEquals(12050, yearsSum);
    }

    @Test
    public void test5a() {
        int yearsSum = bookFunctions.sumAllYears(bookList);
        Assert.assertEquals(12050, yearsSum);
    }

    @Test
    public void test6() {
        int booksAfter2007 = bookFunctions.getBooksPublishedAfter2007Stream(bookList);
        Assert.assertEquals(3, booksAfter2007);
    }

    @Test
    public void test6a() {
        int booksAfter2007 = bookFunctions.getBooksPublishedAfter2007Stream(bookList);
        Assert.assertEquals(3, booksAfter2007);
    }

    @Test
    public void test7() {
        boolean isPublishedAfter2000 = bookFunctions.areBooksPublishedAfter2000Stream(bookList);
        Assert.assertTrue(isPublishedAfter2000);
    }

    @Test
    public void test7a() {
        boolean isPublishedAfter2000 = bookFunctions.areBooksPublishedAfter2000(bookList);
        Assert.assertTrue(isPublishedAfter2000);
    }

    @Test
    public void test8() {
        int yearsMediana = bookFunctions.getYearMedianaStream(bookList);
        Assert.assertEquals(2008, yearsMediana);
    }

    @Test
    public void test8a() {
        int yearsMediana = bookFunctions.getYearMediana(bookList);
        Assert.assertEquals(2008, yearsMediana);
    }

    @Test
    public void test9() {
        boolean isPublishedBefore2003 = bookFunctions.isAnyPublishedBefore2003Stream(bookList);
        Assert.assertTrue(isPublishedBefore2003);
    }

    @Test
    public void test9a() {
        boolean isPublishedBefore2003 = bookFunctions.isAnyPublishedBefore2003(bookList);
        Assert.assertTrue(isPublishedBefore2003);
    }

    //TODO
//    test zadanie 10
//    @Test
//    public void test10a() {
//
//    }

    @Test
    public void test11() {
        List<Book> booksWithDivision = bookFunctions.getBooksWithYearDevideByTwoStream(bookList);
        Book firstSample = booksWithDivision.get(0);
        Book secondSample = booksWithDivision.get(1);
        Book thirdSample = booksWithDivision.get(2);
        Book fourthSample = booksWithDivision.get(3);
        Assert.assertEquals("Clean Code", firstSample.getTitle());
        Assert.assertEquals("Effective Java (3rd Edition)", secondSample.getTitle());
        Assert.assertEquals("Patterns of Enterprise Application Architecture", thirdSample.getTitle());
        Assert.assertEquals("Head First Design Patterns", fourthSample.getTitle());
    }

    @Test
    public void test11a() {
        List<Book> booksWithDivision = bookFunctions.getBooksWithYearDevidedByTwo(bookList);
        Book firstSample = booksWithDivision.get(0);
        Book secondSample = booksWithDivision.get(1);
        Book thirdSample = booksWithDivision.get(2);
        Book fourthSample = booksWithDivision.get(3);
        Assert.assertEquals("Clean Code", firstSample.getTitle());
        Assert.assertEquals("Effective Java (3rd Edition)", secondSample.getTitle());
        Assert.assertEquals("Patterns of Enterprise Application Architecture", thirdSample.getTitle());
        Assert.assertEquals("Head First Design Patterns", fourthSample.getTitle());
    }

    //TODO
//    test zadanie 12
//    @Test
//    public void test12() {
//
//    }

    //TODO
////    test zadanie 13
//    @Test
//    public void test13() {
//        List<Book> reverseSorted = bookFunctions.getReverseSortedBooksYearStream(bookList);
//          Assert.assertEquals("Effective Java (3rd Edition)",);
//    }

    //TODO
//    test zadanie 14
//    @Test
//    public void test14() {
//
//    }


}
