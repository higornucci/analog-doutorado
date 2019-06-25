package final_exe;
//Universidade Federal de Mato Grosso do Sul - Campo Grande
//Programa de Pós-Graduação - Faculdade de Computação (FACOM)
//Análise de Algoritmos - Professor Edson Norberto Cáceres
//Acadêmico Anderson Aparecido dos Santos

//Algorithms Fourth Edition - Robert Sedgewick | Kevin Wayne
//5. Strings
//5.5 Data Compression
//Implemente os algoritmos para compressão de texto usando Códigos de Huffman e compressão LZW. Teste as implementações com conjutos de vários tamanhos. Faça uma avaliação da taxa de compressão para cada algoritmo.

import edu.princeton.cs.algs4.LZW;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Exec6 {

    public static void main(String[] args) {

        //Huffman huf = null;
        LZW lzw = null;

        // Stopwatch tempo1 = new Stopwatch();
		/*if(args[0].equals("-"))
			huf.compress();
		else if(args[0].equals("+"))
			huf.expand();
		StdOut.printf("%.3f\t", tempo.elapsedTime());*/

        Stopwatch tempo2 = new Stopwatch();
        if (args[0].equals("-"))
            lzw.compress();
        else if (args[0].equals("+"))
            lzw.expand();
        StdOut.printf("%.3f\n", tempo2.elapsedTime());
    }
}