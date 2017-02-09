import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dhaval on 11/10/2016.
 */
public class CourseraInterview1 {

    public String flatenDictionary(Map<String, Object> dict) {

        if (dict == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("{");
        sb = flatenDictionary(dict, sb);
        sb.append("}");
        return sb.toString();

    }

    private StringBuilder flatenDictionary(Map<String, Object> map, StringBuilder sb) {

        for (String key : map.keySet()) {
            sb.append(key+":");
            Object curr = map.get(key);
            if (curr instanceof Map) {
                sb.append("{");
                flatenDictionary((Map)curr, sb); //recurssive call
                sb.append("}, ");
            }
            else {
                sb.append(curr+",");
            }
        }
        sb.deleteCharAt(sb.length()-2);
        return sb;
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("b", "blueberry");
        map1.put("c", "cranberry");
        map.put("a", "apple");
        map.put("b", map1);
        //System.out.println(map);
        System.out.println(new CourseraInterview1().flatenDictionary(map));
    }
}
