import java.util.List;

public class YearTitleIsbnBookPrintStrategy implements BookPrintStrategy {
    @Override
    public void print(List<Book> booksList) {
        for (Book book : booksList) {
            System.out.println
                    (book.getYear() + " " +
                            book.getTitle() + " " +
                            book.getIsbn());
        }
    }
}
