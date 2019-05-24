package exercicio_3_3_39;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import util.Constants;

public class TestRedBlackBST {

    public static void main(String[] args) {
        String filePath = Constants.FILES_PATH + args[0];
        In teste = new In(filePath);
        String[] keys = teste.readAllStrings();
        int n = keys.length;
        StdRandom.shuffle(keys);

        RedBlackBST<String, Integer> redBlackBST = new RedBlackBST<String, Integer>();
        for (int i = 0; i < n; i++)
            redBlackBST.put(keys[i], i);
        for (String s : redBlackBST.keys())
            StdOut.println(s + " " + redBlackBST.get(s));

        while (!redBlackBST.isEmpty()) {

            for(String key : redBlackBST.keys()) {
                StdOut.println(key);
            }

            StdOut.println();

            StdOut.println("Delete min");
            redBlackBST.deleteMin();
        }

    }
}
