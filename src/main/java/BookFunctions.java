import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookFunctions {


    List<String> bookList = new ArrayList<>();

    // Znajdź książkę o podanym ISBN. Metoda przyjmuje 2 parametry (isbn, lista wszystkich książek) i zwraca podaną książkę.
    public Book searchByIsbnStream(int isbn, List<Book> allBooks) {
        return allBooks.
                stream()
                .filter(book -> book.getIsbn() == isbn)
                .findFirst()
                .orElse(null);
    }

    public Book searchByIsbn(int isbn, List<Book> allBooks) {
        for (Book book : allBooks) {
            if (book.getIsbn() == isbn) {
                return book;
            }
        }
        return null;
    }


    // Zwróć dwie ostatnie książki.
    public List<Book> getTwoLastBooksStream(List<Book> allBooks) {
        return allBooks
                .stream()
                .skip(allBooks.size() - 2)
                .collect(Collectors.toList());
    }

    public List<Book> getTwoLast(List<Book> allBooks) {
        return allBooks.subList(allBooks.size() - 2, allBooks.size());
    }

    // Zwróć najwcześniej wydana książkę.
    public Book getEarliestPublishedStream(int year, List<Book> allBooks) {
        return allBooks
                .stream()
                .min(Comparator.comparing(Book::getYear))
                .get();
    }


    // Zwróć najpóźniej wydana książkę.
    public Book getLastPublishedStream(int year, List<Book> allBooks) {
        return allBooks
                .stream()
                .max(Comparator.comparing(Book::getYear))
                .get();
    }

    // Zwróć sumę lat wydania wszystkich książek.
//    public int sumAllYearsStream(int year, List<Book> allBooks) {
//        return allBooks
//                .stream()
//                .mapToInt(book -> book.getYear())
//                .sum();
//    }


    // Zwróć liczbę książek wydanych po 2007 roku.
//    public int getBooksPublishedAfter2007Stream(List<Book> allBooks) {
//        return (int) allBooks.stream().filter(book -> book.getYear() > 2007).count();
//    }


    // Zwróć informacje o tym czy wszystkie książki w naszym katalogu są wydane po 2000 roku.
//    public boolean areBooksPublishedAfter2000Stream(List<Book> allBooks) {
//        long count = allBooks.stream().filter(book -> book.getYear() <= 2000).count();
//        return allBooks.size() != count;
//    }


    // Zwróć średni rok wydania książki w naszym katalogu.
//    public int getYearMedianaStream(List<Book> allBooks) {
//        int sumOfYears = allBooks.stream().mapToInt(book -> book.getYear()).sum();
//        return sumOfYears / allBooks.size();
//    }


    // Zwróć informacje o tym czy jakakolwiek książka w naszym katalogu jest wydana przed  2003 rokiem.
//    public boolean isAnyPublishedBefore2003Stream(List<Book> allBooks) {
//        return allBooks.stream().anyMatch(book -> book.getYear() < 2003);
//    }


}

