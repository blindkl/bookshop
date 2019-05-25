import java.util.List;

public class TitleYearIsbnBookPrintStrategy implements BookPrintStrategy {
    @Override
    public void print(List<Book> booksList) {
        for (Book book : booksList) {
            System.out.println
                    (book.getTitle() + " " +
                            book.getYear() + " " +
                            book.getIsbn());
        }
    }
}
