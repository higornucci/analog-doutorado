package exercicio_3_3_39;

import edu.princeton.cs.algs4.StdOut;

public class TestRedBlackBST {

    public static void main(String[] args) {
        String test = "S E A R C H E X A M P L E";
        String[] keys = test.split("\\s+");
        int n = keys.length;

        RedBlackBST<String, Integer> redBlackBST = new RedBlackBST<String, Integer>();
        for (int i = 0; i < n; i++)
            redBlackBST.put(keys[i], i);
        for (String s : redBlackBST.keys())
            StdOut.println(s + " " + redBlackBST.get(s));

        RedBlackBST<String, Integer> testDeleteTheMinimum = new RedBlackBST<String, Integer>();
        testDeleteTheMinimum.put("10", 10);
        testDeleteTheMinimum.put("4", 4);
        testDeleteTheMinimum.put("6", 6);
        testDeleteTheMinimum.put("1", 1);
        testDeleteTheMinimum.put("2", 2);
        testDeleteTheMinimum.put("15", 15);
        testDeleteTheMinimum.put("12", 12);

        while (!testDeleteTheMinimum.isEmpty()) {

            for(String key : testDeleteTheMinimum.keys()) {
                StdOut.println(key);
            }

            StdOut.println();

            StdOut.println("Delete min");
            testDeleteTheMinimum.deleteMin();
        }

    }
}
