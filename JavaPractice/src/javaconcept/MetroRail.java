package javaconcept;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

/**
 * Created by jayapal_uradi on 4/14/17.
 */
public class MetroRail {
    public static void main (String[] args) {

        String line1File = "/Users/jayapal_uradi/Downloads/line1.txt";
        String line2File = "/Users/jayapal_uradi/Downloads/line2.txt";
        String line3File = "/Users/jayapal_uradi/Downloads/line3.txt";

        /*
        X1 Ameerpet Station Line1 & line 3
        X2 M G B S Station Line1 & line 2
        X3 Parade Grounds Station Line 2 & line 3
         */

        LinkedHashMap<String, String> line1Map = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> line2Map = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> line3Map = new LinkedHashMap<String, String>();
        LinkedHashMap<String, Integer> stations1Code = new LinkedHashMap<String, Integer>();
        LinkedHashMap<String, Integer> stations2Code = new LinkedHashMap<String, Integer>();
        LinkedHashMap<String, Integer> stations3Code = new LinkedHashMap<String, Integer>();


        loadLine(line1File, line1Map);
        loadLine(line2File, line2Map);
        loadLine(line3File, line3Map);

        Set<String> stationCodeSet = line1Map.keySet();
        int l1=100;
        int l2=200;
        int l3=300;

        loadCode(line1Map, stations1Code, l1);
        loadCode(line1Map, stations2Code, l2);
        loadCode(line1Map, stations3Code, l3);

        Integer line1x1 = stations1Code.get("X1");
        Integer line1x2 = stations1Code.get("X2");


        Scanner input = new Scanner(System.in);
        System.out.println("Enter the source station");
        String src = input.next();
        System.out.println("Enter the destination station");
        String dst = input.next();

        String srcIdStr = src.substring(1);
        String dstIdStr = dst.substring(1);

        int srcId = Integer.valueOf(srcIdStr);
        int dstId = Integer.valueOf(dstIdStr);

        System.out.println("Src static="+src +" dst Station= " +dst);


        Collection<Integer> codes = stations1Code.values();
        Iterator i = codes.iterator();
        while(i.hasNext()) {
            System.out.print(" "+i.next());
        }

        if ((dstId - srcId) < 1) {
            System.out.println("The given src and dst are not differ by 1 ");
        }

        int stationDiff = (dstId - srcId);
        double fare = 0 ;
        System.out.println("\n The diff between stations is " + (dstId - srcId));

        if (stationDiff >= 3) {
            fare = 10 + (stationDiff - 3)*2.5;
        }

        System.out.println("********************************************************************");
        System.out.println("            Hyderabad Metro Rail ");
        System.out.println("Source:       "+ line1Map.get(src) +"           Distance:"+stationDiff);
        System.out.println("destination:  "+ line1Map.get(dst) + "          Cost:    "+fare);
        System.out.println("********************************************************************");
    }

    public static void loadCode(LinkedHashMap<String, String> lineMap, LinkedHashMap<String, Integer> stationCode, int code) {
        Set<String> stationCodeSet = lineMap.keySet();
        Iterator i = stationCodeSet.iterator();
        while(i.hasNext()) {
            //System.out.print(" "+i.next());
            stationCode.put(i.next().toString(), code++);
        }
    }

    public static void loadLine (String fileName, LinkedHashMap<String, String> lineMap ) {
        System.out.println("Loading line entries from "+fileName);
        Scanner scan = null;
        File file = new File(fileName);

        try {
            scan =  new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            System.out.println(str);
            String[] sa = str.split("\\s+", 2);
            System.out.println(sa[0] + "  - " + sa[1]);
            lineMap.put(sa[0], sa[1]); // Array indexOutOfBoundsException if there is new line at the end of file
        }
    }
}

class station {

    String stationName;
    String stationCode;

    station (String name, String code) {
        this.stationName = name;
        this.stationCode = code;
    }


    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }
}


