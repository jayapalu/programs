package javaconcept;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class CalendarTest {

    public static void main(String[] args) {


double payment = 1234567.10;
        Locale[] locales = {Locale.US, Locale.CHINA, Locale.FRANCE};
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getCurrencyInstance(locales[0]);
        String us =formatter.format(payment);

        formatter = (DecimalFormat) NumberFormat.getCurrencyInstance(new Locale("en", "in"));
        String india =formatter.format(payment);

        formatter = (DecimalFormat) NumberFormat.getCurrencyInstance(locales[1]);
        String china =formatter.format(payment);

        formatter = (DecimalFormat) NumberFormat.getCurrencyInstance(locales[2]);
        String france =formatter.format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);

    Scanner scanner = new Scanner(System.in);

    int mm = scanner.nextInt();

    int dd = scanner.nextInt();

    int yy = scanner.nextInt();

    Calendar ca = Calendar.getInstance();

    ca.set(yy,mm-1,dd);
        String[] str = {"January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"};

    int dayOfWeek = ca.get(Calendar.DAY_OF_WEEK);

        String Day[]={"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
        System.out.println(Day[dayOfWeek-1]);
        System.out.println(str[ca.get(Calendar.MONTH)]);




    }




}
