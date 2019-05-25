public class Category {
    private int id;
    private String categoryName;
    private int priority;

    public Category(int id, String categoryName, int priority) {
        this.id = id;
        this.categoryName = categoryName;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", priority=" + priority +
                '}';
    }
}
