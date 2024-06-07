import java.util.Arrays;
import java.util.Set;

/**
 *
 * @author erso 
 *  Udleveret kode skelet med main()-metode til opgave 4, VOP eksamen 10 juni 2016
 */
public class Mountain implements Comparable<Mountain> {
     String name;
     String height;
     String prominence;
     String latitude;
     String longitude;
     String range;

     Set<Mountain> tree;


     public Mountain(String name, String height, String prominence, String latitude, String longitude, String range){
        this.name = name;
        this.height = height;
        this.prominence = prominence;
        this.latitude = latitude;
        this.longitude = longitude;
        this.range = range;
    }

    @Override
    public String toString() {
        return name + " h=" + height + ", pro=" + prominence + ", lat=" + latitude + ", lon=" + longitude + ", ran=" + range;
    }

    @Override
    public int compareTo(Mountain o) {
        if (Integer.parseInt(prominence)  > Integer.parseInt(o.prominence)){
            return 1;
        } else if (Integer.parseInt(prominence)  < Integer.parseInt(o.prominence)) {
            return -1;
        } else if (Integer.parseInt(height)  > Integer.parseInt(o.height)) {
            return 1;
        } else if (Integer.parseInt(height) < Integer.parseInt(o.height)) {
            return -1;
        } else return 0;
    }
    

    /**
     * @param args
     */
    public static void main(String[] args) {
        // For testing the Mountain-class

        //Opg a Test of constructor and toString()
        // NB: \u00B0 is unicode for the degree-symbol
        Mountain m = new Mountain("Mont Ventoux", "1909", "1148", "44\u00B010'26\"", "05\u00B016'42\"", "Alps");
        System.out.println(m);

        // Opg b Test of compareTo()
        Mountain[] testArray = new Mountain[4];
        testArray[0] = new Mountain("Pic du Midi d'Ossau", "2886", "1092", "42\u00B048'22\"", "-00\u00B025'05\"", "Pyrenees");
        testArray[1] = new Mountain("Pica d'Estats", "3143", "1281", "42\u00B042'43\"", "00\u00B057'23\"", "Pyrenees");
        testArray[2] = new Mountain("Pic de Bure", "2709", "1268", "44\u00B037'38\"", "05\u00B056'07\"", "Alps");
        testArray[3] = new Mountain("Mont Chaberton", "3131", "1281", "44\u00B057'53\"", "06\u00B045'06\"", "Alps");

        System.out.println("Unsorted: ");
        System.out.println(Arrays.toString(testArray));

        System.out.println("Sorted: ");
        Arrays.sort(testArray);
        System.out.println(Arrays.toString(testArray));

    }

    public String getRange() {
        return range;
    }
}
