package paulo.android.nackademin.mybookstorefinal;


public class Book {

    private int imageId;
    private String bookName;
    private String description;
    private double price;

    //Empty Constructor
    public Book() {
    }

    public Book(int imageId, String prodName, String description, double price) {
        this.imageId = imageId;
        this.bookName = prodName;
        this.description = description;
        this.price = price;
    }


    public Book(int imageId, String bookName, double price) {
        this.imageId = imageId;
        this.bookName = bookName;
        this.price = price;
    }

    public int getImageId() {
        return imageId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return bookName;
    }

}
