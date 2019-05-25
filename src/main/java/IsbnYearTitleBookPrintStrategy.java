import java.util.List;

public class IsbnYearTitleBookPrintStrategy implements BookPrintStrategy {
    @Override
    public void print(List<Book> booksList) {
        for (Book book : booksList) {
            System.out.println
                    (book.getIsbn() + " " +
                            book.getYear() + " " +
                            book.getTitle());
        }
    }
}
