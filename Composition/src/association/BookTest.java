package association;

/**
 * Created by jayapal_uradi on 4/20/18.
 */
public class BookTest {

    public static void main (String args[]) {

        Author a1 = new Author("Jayapal", "jay@gmail.com", 'm');
        Author a2 = new Author("Uradi", "uradi@gmail", 'm');

        Book b1 = new Book("Java", a1, 25);
        Book b2 = new Book("Java2", a2, 30.50);

        b1.getBookDetails();
        b2.getBookDetails();

    }
}
