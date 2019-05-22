package exercicio_3_5_13;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import util.Constants;

public class Exercicio13 {

    // Parameters example: 0: csv_file.txt
    //                     1: 0
    //                     2: 1

    // Queries: arnold fzkey
    //          rachel wrong

    // Output expected:
    // arnold 200
    // dijkstra 10
    // dwayne 201
    // fenwick 202
    //
    // rene 5
    // sedgewick 9
    // wayne 10

    private void rangeLookupCSV(String[] args) {
        String filePath = Constants.FILES_PATH + args[0];

        In in = new In(filePath);
        int keyField = Integer.parseInt(args[1]);
        int valueField = Integer.parseInt(args[2]);

        RedBlackBST<String, String> symbolTable = new RedBlackBST<String, String>();

        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[keyField];
            String value = tokens[valueField];

            symbolTable.put(key, value);
        }

        String palavras[] = {"abilityes", "varity"};
        for(String palavra : palavras) {
            if (symbolTable.contains(palavra)) {
                StdOut.print("Você escreveu \"" + palavra + "\", mas o correto é ");
                StdOut.println(symbolTable.get(palavra));
            } else {
                StdOut.println("Palavra não encontrada.");
            }
            StdOut.println();
        }
    }

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        new Exercicio13().rangeLookupCSV(args);
        System.out.println("Tempo total : " + stopwatch.elapsedTime() + " segundos.");
    }

}
