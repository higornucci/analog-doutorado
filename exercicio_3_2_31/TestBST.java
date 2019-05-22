/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

package exercicio_3_2_31;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import util.Constants;

public class TestBST {
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        String filePath = Constants.FILES_PATH + args[0];
        In teste = new In(filePath);
        String[] keys = teste.readAllStrings();
        int n = keys.length;
        StdRandom.shuffle(keys);

        BST<String, Integer> st = new BST<String, Integer>();
        for (int i = 0; i < n; i++)
            st.put(keys[i], i);
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));

        StdOut.println(st.isBST(st.root) + " Expected: true");


        BST<String, Integer> notBST = new BST<String, Integer>();
        notBST.root = new BST().new Node(20, "Value 1", 7);
        notBST.root.left = new BST().new Node(5, "Value 5", 4);
        notBST.root.left.left = new BST().new Node(2, "Value 2", 1);
        notBST.root.left.right = new BST().new Node(1, "Value 1", 2); //Not a BST
        notBST.root.left.right.right = new BST().new Node(9, "Value 9", 1);

        notBST.root.right = new BST().new Node(24, "Value 24", 2);
        notBST.root.right.left = new BST().new Node(21, "Value 21", 1);

        StdOut.println(notBST.isBST(notBST.root) + " Expected: false");
        System.out.println("Tempo total : " + stopwatch.elapsedTime() + " segundos.");

    }
}
