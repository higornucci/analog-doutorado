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
        Stopwatch stopwatchTotal = new Stopwatch();
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

        Stopwatch stopwatchSize = new Stopwatch();
        StdOut.println("size = " + st.size());
        System.out.println("Tempo total size() : " + stopwatchSize.elapsedTime() + " segundos.");
        Stopwatch stopwatchMin = new Stopwatch();
        StdOut.println("min  = " + st.min());
        System.out.println("Tempo total min() : " + stopwatchMin.elapsedTime() + " segundos.");
        Stopwatch stopwatchMax = new Stopwatch();
        StdOut.println("max  = " + st.max());
        System.out.println("Tempo total max() : " + stopwatchMax.elapsedTime() + " segundos.");
        StdOut.println();


        // print keys in order using keys()
        Stopwatch stopwatchKeys = new Stopwatch();
        StdOut.println("Testing keys()");
        StdOut.println("--------------------------------");
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s));
        System.out.println("Tempo total keys() : " + stopwatchKeys.elapsedTime() + " segundos.");
        StdOut.println();


        // print keys in order using select
        Stopwatch stopwatchSelect = new Stopwatch();
        StdOut.println("Testing select");
        StdOut.println("--------------------------------");
        for (int i = 0; i <= st.size(); i++)
            StdOut.println(i + " " + st.select(i));
        System.out.println("Tempo total select() : " + stopwatchSelect.elapsedTime() + " segundos.");
        StdOut.println();

        // test rank, floor, ceiling
        Stopwatch stopwatchCeil = new Stopwatch();
        StdOut.println("key rank floor ceil");
        StdOut.println("-------------------");
        for (char i = 'A'; i <= 'Z'; i++) {
            String s = i + "";
            StdOut.printf("%2s %4d %4s %4s\n", s, st.rank(s), st.floor(s), st.ceiling(s));
        }
        System.out.println("Tempo total ceiling() : " + stopwatchCeil.elapsedTime() + " segundos.");
        StdOut.println();

        // test range search and range count
        Stopwatch stopwatchSearch = new Stopwatch();
        String[] from = { "A", "Z", "X", "0", "B", "C" };
        String[] to   = { "Z", "A", "X", "Z", "G", "L" };
        StdOut.println("range search");
        StdOut.println("-------------------");
        for (int i = 0; i < from.length; i++) {
            StdOut.printf("%s-%s (%2d) : ", from[i], to[i], st.size(from[i], to[i]));
            for (String s : st.keys(from[i], to[i]))
                StdOut.print(s + " ");
            StdOut.println();
        }
        System.out.println("Tempo total search() : " + stopwatchSearch.elapsedTime() + " segundos.");
        StdOut.println();


        // delete the smallest keys
        Stopwatch stopwatchDeleteMin = new Stopwatch();
        for (int i = 0; i < st.size() / 2; i++) {
            st.deleteMin();
        }
        StdOut.println("After deleting the smallest " + st.size() / 2 + " keys");
        StdOut.println("--------------------------------");
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s));
        System.out.println("Tempo total deletMin() : " + stopwatchDeleteMin.elapsedTime() + " segundos.");
        StdOut.println();

        // delete all the remaining keys
        Stopwatch stopwatchDelete = new Stopwatch();
        while (!st.isEmpty()) {
            st.delete(st.select(st.size() / 2));
        }
        StdOut.println("After deleting the remaining keys");
        StdOut.println("--------------------------------");
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s));
        System.out.println("Tempo total delete() : " + stopwatchDelete.elapsedTime() + " segundos.");
        StdOut.println();

        Stopwatch stopwatchPutAll = new Stopwatch();
        StdOut.println("After adding back N keys");
        StdOut.println("--------------------------------");
        for (int i = 0; i < n; i++) 
            st.put(keys[i], i); 
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s));
        System.out.println("Tempo total put() : " + stopwatchPutAll.elapsedTime() + " segundos.");
        StdOut.println();
        System.out.println("Tempo total : " + stopwatchTotal.elapsedTime() + " segundos.");

    }
}
