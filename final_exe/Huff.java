//Universidade Federal de Mato Grosso do Sul - Campo Grande
//Programa de Pós-Graduação - Faculdade de Computação (FACOM)
//Análise de Algoritmos - Professor Edson Norberto Cáceres
//Acadêmico Anderson Aparecido dos Santos

//Algorithms Fourth Edition - Robert Sedgewick | Kevin Wayne
//5. Strings
//5.5 Data Compression
//Implemente os algoritmos para compressão de texto usando Códigos de Huffman e compressão LZW. Teste as implementações com conjutos de vários tamanhos. Faça uma avaliação da taxa de compressão para cada algoritmo.

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.Huffman;
import edu.princeton.cs.algs4.StdOut;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Huff{
	
	public static void main(String[] args) throws IOException{
		
		Huffman huff = null;

		Stopwatch tempo = new Stopwatch();
		if(args[0].equals("-"))
			huff.compress();
		else if(args[0].equals("+"))
			huff.expand();
		double time = tempo.elapsedTime();

		if (args[0].equals("-")) {
			FileWriter arq = new FileWriter("tempos/compactar/huffman/" + args[1], true);
			PrintWriter gravarArq = new PrintWriter(arq, true);

			gravarArq.printf(time + "\n");

			arq.close();
		}
		if (args[0].equals("+")) {
			FileWriter arq = new FileWriter("tempos/descompactar/huffman/" + args[1], true);
			PrintWriter gravarArq = new PrintWriter(arq, true);

			gravarArq.printf(time + "\n");

			arq.close();
		}
	}
}