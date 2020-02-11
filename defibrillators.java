import java.util.*;
import java.math.*;
 
class Solution {
    /** Returns the distance between a point A and a point B
     * @param longA longitude of point A
     * @param latA latitude of point A
     * @param longB longitude of point B
     * @param latB latitude of point B
     * @return distance between A and B
     */
    private static double distance(double longA, double latA, double longB, double latB){
        double x = (longB-longA)*Math.cos((latA+latB)/2);
        double y = latB - latA;
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2)) * 6371;
    }
 
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        /* as the latitude and the longitude are given with , instead of .
           it isn't possible to use nextFloat()*/
        Double lon = new Double(in.next().replace(',', '.'));
        Double lat = new Double(in.next().replace(',', '.'));
        int N = in.nextInt();
        in.nextLine();
 
        // simple min search amongst defibrillators
        double min = Double.POSITIVE_INFINITY;
        String res = "";
        Double d;
        for (int i = 0; i < N; i++) {
            String[] defib = in.nextLine().replace(',', '.').split(";");
            d = distance(lon, lat, new Double(defib[4]), new Double(defib[5]));
            if (d < min) {
                min = d;
                res = defib[1];
            }
        }
        System.out.println(res);
    }
}
       
