import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

/**
 * Created by jayapal_uradi on 3/10/17.
 */
public class CustomeException extends Exception {

    public static void main (String [] args) {

        try {
            System.out.println("In customException");
            throw new UserDefinedException("This is a test user defined exception");

        } catch (UserDefinedException ex) {
            System.out.println("Exceptoin msg =" + ex);
        }
    }


}

class UserDefinedException extends Exception  {
    String message;

    public UserDefinedException(String msg) {
        this.message = msg;
    }

    @Override
    public  String toString() {
        return message;
    }
}