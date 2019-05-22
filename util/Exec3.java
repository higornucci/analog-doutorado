package util;// Chap. 3 Searching
// Sec. 3.3 Balanced Search Trees
// Creative Problems. 33. Certification. Add to RedBlackBST.java a method is23() to check that no node is connected to two red links and that there are no right-leaning red links. Add a method isBalanced() to check that all paths from the root to a null link have the same number of black links. Combine these methods with isBST() to create a method isRedBlackBST() that checks that the tree is a BST and that it satisfies these two conditions.
// Anderson Aparecido dos Santos

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import exercicio_3_3_39.RedBlackBST;

public class Exec3{

	public static void main(String[] args){

		//tempo para carregar o arquivo
		Stopwatch tempo = new Stopwatch();
		In test = new In(args[0]);
		String[] keys = test.readAllStrings();
		int n = keys.length;
		StdOut.print(tempo.elapsedTime() + "\t");

		StdRandom.shuffle(keys);

		//tempo para gerar a arvore
		tempo = new Stopwatch();
		RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();
		for (int i = 0; i < n; i++)
			st.put(keys[i], i);
		StdOut.print(tempo.elapsedTime() + "\t");

		//tempo para calcular is23()
		tempo = new Stopwatch();
		// boolean is23 = st.is23();
		// StdOut.print(is23 + "\t" + tempo.elapsedTime() + "\t");
		//
		// //tempo para calcular isBalanced()
		// tempo = new Stopwatch();
		// boolean isBalanced = st.isBalanced();
		// StdOut.print(isBalanced + "\t" + tempo.elapsedTime() + "\t");
		//
		// //tempo para calcular isBST()
		// tempo = new Stopwatch();
		// boolean isBST = st.isBST();
		// StdOut.print(isBST + "\t" + tempo.elapsedTime() + "\t");
		//
		// //tempo para calcular isRedBlackBST()
		// tempo = new Stopwatch();
		// boolean isRedBlackBST = st.isRedBlackBST();
		// StdOut.print(isRedBlackBST + "\t" + tempo.elapsedTime() + "\t");

		StdOut.println();
	}
}
