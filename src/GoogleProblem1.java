/**
 * Created by Dhaval on 10/18/2016.
 */
public class GoogleProblem1 {

    public int solution(int X) {

        String s = String.valueOf(X);
        int maxNumber = Integer.MIN_VALUE;
        int len = s.length();
        for (int i = 0; i < len -1; i++) {
            StringBuilder sb = new StringBuilder();
            String average = getAverageValue(s.substring(i, i+2));
            sb.append(s.substring(0, i) + average + s.substring(i+2, len));
            maxNumber = Math.max(maxNumber, Integer.valueOf(sb.toString()));

        }
        return maxNumber;
    }

    private String getAverageValue(String s) {
        int len = s.length();
        int sum = 0;
        for (int i = 0; i  < len; i++) {
            sum += s.charAt(i) - 48;
        }
        return Integer.toString((int)Math.ceil(sum/2.0));
    }

    public static void main(String[] args) {
        System.out.println(new GoogleProblem1().solution(623315));
    }
}
