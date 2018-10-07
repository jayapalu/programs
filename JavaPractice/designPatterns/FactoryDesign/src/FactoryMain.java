import com.phone.Android;
import com.phone.OS;
import com.phone.OperatinSystemFactory;
import com.phone.Windows;

/**
 * Created by jayapal_uradi on 8/8/17.
 */
public class FactoryMain {
    public static void main(String args[]) {

        OS os = new Android();
        os.spec();

        OS w = new Windows();
        w.spec();

        System.out.println("Calling spec with OS factory ...............");
        OperatinSystemFactory osf = new OperatinSystemFactory();
        osf.getInstance("windows").spec();
        osf.getInstance("ios").spec();
        osf.getInstance("android").spec();
    }
}
