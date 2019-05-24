package exercicio_3_1_29;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import util.Constants;

/******************************************************************************
 *  Compilation:  javac TestBinarySearchST.java
 *  Execution:    java -ea TestBinarySearchST
 *  Dependencies: java BinarySearchST.java
 *  
 *  Test client for BinarySearchST
 *
 *  % java TestBinarySearchST
 *
 *  Test client for BinarySearchST.java.
 *
 ******************************************************************************/


public class TestBinarySearchST {

   /***************************************************************************
    *  Unit test client.
    ***************************************************************************/
    public static void main(String[] args) {
        String filePath = Constants.FILES_PATH + args[0];
        In teste = new In(filePath);
        String[] keys = teste.readAllStrings();
        int n = keys.length;
        StdRandom.shuffle(keys);

        Stopwatch stopwatchConstrucaoArvore = new Stopwatch();
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
        for (int i = 0; i < n; i++) 
            st.put(keys[i], i);
        System.out.println("Tempo total para construção da árvore : " + stopwatchConstrucaoArvore.elapsedTime() + " segundos.");

        Stopwatch stopwatchMin = new Stopwatch();
        StdOut.println("min  = " + st.min());
        System.out.println("Tempo total min() : " + stopwatchMin.elapsedTime() + " segundos.");
        Stopwatch stopwatchMax = new Stopwatch();
        StdOut.println("max  = " + st.max());
        System.out.println("Tempo total max() : " + stopwatchMax.elapsedTime() + " segundos.");
        StdOut.println();


        // print keys in order using keys()
        StdOut.println("Testing keys()");
        Stopwatch stopwatchKeys = new Stopwatch();
        st.keys();
        System.out.println("Tempo total keys() : " + stopwatchKeys.elapsedTime() + " segundos.");
        StdOut.println("--------------------------------");
        StdOut.println();


        // print keys in order using select
        StdOut.println("Testing select");
        Stopwatch stopwatchSelect = new Stopwatch();
        st.select(56);
        System.out.println("Tempo total select() : " + stopwatchSelect.elapsedTime() + " segundos.");
        StdOut.println("--------------------------------");
        StdOut.println();

        // test rank, floor, ceiling
        StdOut.println("key rank floor ceil");
        String s = "A";
        Stopwatch stopwatchCeil = new Stopwatch();
        st.ceiling(s);
        System.out.println("Tempo total ceiling() : " + stopwatchCeil.elapsedTime() + " segundos.");
        StdOut.println();
        Stopwatch stopwatchRank = new Stopwatch();
        st.rank(s);
        System.out.println("Tempo total rank() : " + stopwatchRank.elapsedTime() + " segundos.");
        StdOut.println();
        Stopwatch stopwatchFloor = new Stopwatch();
        st.floor(s);
        System.out.println("Tempo total floor() : " + stopwatchFloor.elapsedTime() + " segundos.");
        StdOut.println("-------------------");
        StdOut.println();


        Stopwatch stopwatchDeleteMin = new Stopwatch();
        st.deleteMin();
        System.out.println("Tempo total deleteMin() : " + stopwatchDeleteMin.elapsedTime() + " segundos.");
        Stopwatch stopwatchDeleteMax = new Stopwatch();
        st.deleteMax();
        System.out.println("Tempo total deleteMax() : " + stopwatchDeleteMax.elapsedTime() + " segundos.");

    }
}
