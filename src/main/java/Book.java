public class Book {

    private int id;
    private String title;
    private int isbn;
    private int year;


    public Book(int id, String title, int isbn, int year) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn=" + isbn +
                ", year=" + year +
                '}';
    }

    public void setYear(int year) {
        this.year = year;
    }


}
