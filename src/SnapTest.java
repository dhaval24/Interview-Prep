import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhaval on 11/20/2016.
 */
public class SnapTest {

    private static final int R = 256;
    List<String> simpleWords;
    private Node root;

    public SnapTest() {

        simpleWords = new ArrayList<>();
        root = new Node();

    }

    private class Node {

        boolean isWord;
        Node[] next = new Node[R];

    }

    public void put(List<String> words) {
        for (String word : words) {
            root = put(root, word, true, 0);

        }

    }

    private Node put(Node x, String word, boolean value, int d) {

        return null;
    }


    public static void main(String[] args) {
        SnapTest st = new SnapTest();
        List<String> words = new ArrayList<>();
        words.add("so");
        words.add("per");
        words.add("son");
        st.put(words);
    }




}
