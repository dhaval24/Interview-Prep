import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Dhaval on 1/19/2017.
 */
public class LogHistoryPureStorage {

    public int check_log_history(String[] events) {

        if (events == null) throw new IllegalArgumentException();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();

        int len = events.length;
        for (int i = 0; i < len; i++) {
            String[] arr = events[i].split(" ");
            if (arr[0].equals("ACQUIRE")) {
                if (set.contains(Integer.parseInt(arr[1]))) {
                    return (i+1);
                }
                set.add(Integer.parseInt(arr[1]));
                stack.push(Integer.parseInt(arr[1]));
            }
            else if (arr[0].equals("RELEASE")) {
                if (stack.peek() != Integer.parseInt(arr[1])) {
                    return (i+1);
                }
                set.remove(Integer.parseInt(arr[1]));
                stack.pop();
            }
        }
        return len;
    }
}
