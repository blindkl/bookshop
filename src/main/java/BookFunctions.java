import java.util.*;
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
                .min(Comparator.comparingInt(Book::getYear))
                .get();
    }

    public Optional<Book> getEarliestPublishedStream2(int year, List<Book> allBooks) {
        Optional<Book> book = allBooks
                .stream()
                .min(Comparator.comparingInt(Book::getYear));
        return book;
    }

    public Book getEarliestPublished(int year, List<Book> allBooks) {
        Book earliestBook = allBooks.get(0);
        for (Book book : allBooks) {
            if (book.getYear() < earliestBook.getYear()) {
                earliestBook = book;
            }
        }
        return earliestBook;
    }

    // Zwróć najpóźniej wydana książkę.
    public Book getLastPublishedStream(int year, List<Book> allBooks) {
        return allBooks
                .stream()
                .max(Comparator.comparingInt(Book::getYear))
                .get();
    }

    public Optional<Book> getLastPublishedStream2(int year, List<Book> allBooks) {
        Optional<Book> book = allBooks
                .stream()
                .max(Comparator.comparingInt(Book::getYear));
        return book;
    }

    public Book getLastPublished(int year, List<Book> allBooks) {
        Book lastPublishedBook = allBooks.get(0);
        for (Book book : allBooks) {
            if (book.getYear() > lastPublishedBook.getYear()) {
                lastPublishedBook = book;
            }
        }
        return lastPublishedBook;
    }


    // Zwróć sumę lat wydania wszystkich książek.
    public int sumAllYearsStream(List<Book> allBooks) {
        return allBooks
                .stream()
                .mapToInt(Book::getYear)
                .sum();
    }

    public int sumAllYears(List<Book> allBooks) {
        int addedYears = 0;
        for (Book book : allBooks) {
            addedYears += book.getYear();
        }
        return addedYears;
    }


    // Zwróć liczbę książek wydanych po 2007 roku.
    public int getBooksPublishedAfter2007Stream(List<Book> allBooks) {
        return (int) allBooks.stream().filter(book -> book.getYear() > 2007).count();
    }

    public int getBooksPublishedAfter2007(List<Book> allBooks) {
        int booksAfter2007 = 0;
        for (Book book : allBooks) {
            if (book.getYear() > 2007) {
                booksAfter2007 += 1;
            }
        }
        return booksAfter2007;
    }


    // Zwróć informacje o tym czy wszystkie książki w naszym katalogu są wydane po 2000 roku.
    public boolean areBooksPublishedAfter2000Stream(List<Book> allBooks) {
        long count = allBooks.stream().filter(book -> book.getYear() >= 2000).count();
        return allBooks.size() == count;
    }

    public boolean areBooksPublishedAfter2000(List<Book> allBooks) {
        boolean booksAfter2000 = true;
        for (Book book : allBooks) {
            if (book.getYear() <= 2000) {
                booksAfter2000 = false;
            }
        }
        return booksAfter2000;
    }


    // Zwróć średni rok wydania książki w naszym katalogu.
    public int getYearMedianaStream(List<Book> allBooks) {
        int sumOfYears = allBooks.stream().mapToInt(Book::getYear).sum();
        return sumOfYears / allBooks.size();
    }

    public int getYearMediana(List<Book> allBooks) {
        int sumOfYears = 0;
        for (Book book : allBooks) {
            sumOfYears += book.getYear();
        }
        return sumOfYears / allBooks.size();
    }


    // Zwróć informacje o tym czy jakakolwiek książka w naszym katalogu jest wydana przed  2003 rokiem.
    public boolean isAnyPublishedBefore2003Stream(List<Book> allBooks) {
        return allBooks.stream()
                .anyMatch(book -> book.getYear() < 2003);
    }

    public boolean isAnyPublishedBefore2003(List<Book> allBooks) {
        boolean statement = false;
        for (Book book : allBooks) {
            if (book.getYear() < 2003) {
                statement = true;
            }
        }
        return statement;
    }

    // Zwróć wszystkie książki, których tytuł zaczyna się od litery “C” i były one wydane po 2007 roku

    public List<Book> getBooksStartWithCPublishedAfter2007Stream(List<Book> allBooks) {
        return allBooks
                .stream()
                .filter(book -> book.getTitle().startsWith("C"))
                .filter(book -> book.getYear() > 2007)
                .collect(Collectors.toList());
    }

    public List<Book> getBooksStartWithCPublishedAfter2007(List<Book> allBooks) {
        List<Book> startWithC = new ArrayList<>();
        for (Book book : allBooks) {
            if ((book.getTitle().startsWith("C")) && ((book.getYear() > 2007))) {
                startWithC.add(book);
            }
        }
        return startWithC;
    }

    // Zwróć tytuły wszystkich książek, których rok jest podzielny przez 2

    public List<Book> getBooksWithYearDevideByTwoStream(List<Book> allBooks) {
        return allBooks
                .stream()
                .filter(book -> book.getYear() % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Book> getBooksWithYearDevidedByTwo(List<Book> allBooks) {
        List<Book> booksWithYearDevidedByTwo = new ArrayList<>();
        for (Book book : allBooks) {
            if (book.getYear() % 2 == 0) {
                booksWithYearDevidedByTwo.add(book);
            }
        }
        return booksWithYearDevidedByTwo;
    }

    //    Zwróć mapę, która będzie miała klucz isbn i wartość obiekt Book (Map<String, Book>).
    public Map<Integer, Book> getMapWithIsbnValueStream(List<Book> allBooks) {
        Map<Integer, Book> map = allBooks
                .stream()
                .collect(Collectors.toMap(Book::getIsbn, Book -> Book));
        return map;
    }

    //    Posortuj książki po roku wydania zaczynając od wydanej najpóźniej.
    public List<Book> getReverseSortedBooksYearStream(int year, List<Book> allBooks) {
        return allBooks
                .stream()
                .sorted(Comparator.comparingInt(Book::getYear).reversed())
                .collect(Collectors.toList());
    }

    //    Posortuj książki po roku wydania zaczynając od wydanej najwcześniej.
    public List<Book> getSortedBooksYearStream(int year, List<Book> allBooks) {
        return allBooks
                .stream()
                .sorted(Comparator.comparingInt(Book::getYear))
                .collect(Collectors.toList());
    }

    //    Podziel listę książek na 3 listy po 2 książki i zwróć z metody. (*) (bez streama)

    //    Pogrupuj książki po roku wydania. Metoda powinna zwrócić Map<Integer, List<Book>> gdzie kluczem jest rok wydania a wartością lista książek wydana w tym roku. (*)

    //    Podziel książki na te wydane po 2009 roku i pozostałe. Metoda powinna zwrócić Map<Boolean, List<Book>> gdzie kluczem jest boolean oznaczający czy została wydana po 2009 a wartością będą listy książek. (*)


}


