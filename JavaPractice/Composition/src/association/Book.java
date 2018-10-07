package association;

/**
 * Created by jayapal_uradi on 4/20/18.
 */
public class Book {

    private String title;
    private Author author;
    private double price;
    private int quantity = 1;

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


    public Book(String title, Author author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book(String title, Author author, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "association.Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public void getBookDetails() {

        System.out.println ("association.Book title: "+this.getTitle() +"  association.Author: "+this.getAuthor());
    }
}
