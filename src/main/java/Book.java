public class Book {

    private String title;
    private int isbn;
    private int year;


    public Book(int id, String title, int isbn, int year) {
        this.title = title;
        this.isbn = isbn;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public long getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

}
