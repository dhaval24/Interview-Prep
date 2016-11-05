
/**
 * Created by krutarthjoshi on 10/18/16.
 */
public class RoundedDigits {

    public static void main(String[] args) {
        RoundedDigits roundedDigits = new RoundedDigits();
        System.out.println(roundedDigits.getLargest(9631));
    }

    private int getLargest(int n) {
        //Invalid Input
        if (n < 0) {
            return -1;
        }

        //Since there's just a single digit, no average can be taken
        if (n < 10) {
            return 0;
        }

        //Converting the Integer to String for convenience
        String s = Integer.toString(n);
        int l = s.length();
        int avg = 0;

        /*The core logic follows as -
            We go from the most significant bit towards the least significant bit.
            If the average obtained is either equal to or greater than the more significant of
            the two whom average we've considered, that's where we stop.
            If we don't find any such instance, we reach the end and return the avg. of the two least significant
            bits as it would be the greatest of all.
        */
        for (int i = 0; i < l - 1; i++) {
            String prev = s.substring(0, i);
            String nex = s.substring(i + 2, s.length());
            avg = (int) Math.ceil((s.charAt(i) - '0' + s.charAt(i + 1) - '0') / 2.0);
            if (avg >= s.charAt(i) - '0') {
                String res = prev + String.valueOf(avg) + nex;
                return Integer.valueOf(res);
            }
        }
        return Integer.valueOf(s.substring(0, l - 2) + String.valueOf(avg));
    }
}
