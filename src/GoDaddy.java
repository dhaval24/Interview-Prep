import java.util.Arrays;

/**
 * Created by Dhaval on 1/16/2017.
 */
public class GoDaddy {

    static int pointer = 0;
    public String[] buildSubsequences(String s) {

        if (s == null) throw new NullPointerException();
        int len = s.length();
        String[] result = new String[(int)Math.pow(2, len) - 1];
        return buildSubsequences(s, result, "", 0);
    }

    public String[] buildSubsequences(String s, String[] result, String temp, int index) {
        if (index == s.length()) {
            return result;
        }

        for (int i = index; i < s.length(); i++) {
            temp += s.charAt(i);
            result[pointer++] = new String(temp);
            buildSubsequences(s, result, temp, ++index);
            temp = temp.substring(0, temp.length()-1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GoDaddy().buildSubsequences("abc")));
    }
}
