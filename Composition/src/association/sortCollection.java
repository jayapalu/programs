package association;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jayapal_uradi on 4/20/18.
 */
public class sortCollection {

    public static void main (String args[]) {

        List persons = new ArrayList<>(5);

        Random rand = new Random();

        for (int i = 0; i< 5 ; i++) {

            int r = rand.nextInt(20) + 1;
            persons.add(new person("association.person"+i, r));
        }

        for (int i=0;i<5; i++){
            System.out.println(" Person -> " + persons.get(i).toString());
        }
    }
}
