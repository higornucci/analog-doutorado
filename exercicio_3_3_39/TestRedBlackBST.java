package exercicio_3_3_39;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import util.Constants;

public class TestRedBlackBST {

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        String filePath = Constants.FILES_PATH + args[0];
        In teste = new In(filePath);
        String[] keys = teste.readAllStrings();
        int n = keys.length;
        StdRandom.shuffle(keys);

        RedBlackBST<String, Integer> redBlackBST = new RedBlackBST<String, Integer>();
        for (int i = 0; i < n; i++)
            redBlackBST.put(keys[i], i);
        System.out.println("Tempo total para construir a árvore: " + stopwatch.elapsedTime() + " segundos.");

        Stopwatch stopwatchDeleteMin = new Stopwatch();
        StdOut.println("Delete min");
        redBlackBST.deleteMin();
        System.out.println("Tempo total deleteMin(): " + stopwatchDeleteMin.elapsedTime() + " segundos.");
    }
}
