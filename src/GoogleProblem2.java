/**
 * Created by Dhaval on 9/25/2016.
 */
public class GoogleProblem2 {

    public int lengthLongestPath(String input) {

        String[] paths = input.split("\\n");
        int[] stack = new int[paths.length+1];
        int maxLen = 0;
        for(String s:paths){
            int lev = s.lastIndexOf(" ")+1;
            stack[lev+1] = stack[lev]+s.length()-lev+1;
            int curLen = stack[lev+1];
            if(s.contains(".jpeg")) {
                maxLen = Math.max(maxLen, curLen);
            }
            if(s.contains(".png")) {
                maxLen = Math.max(maxLen, curLen);
            }
            if(s.contains(".gif")) {
                maxLen = Math.max(maxLen, curLen);
            }

        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new GoogleProblem2().lengthLongestPath("dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndhavaldoshidirectory2\n file2.jpeg"));
    }

}
