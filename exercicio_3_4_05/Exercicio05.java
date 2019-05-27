package exercicio_3_4_05;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import util.Constants;

public class Exercicio05 {

    private static String passwordChecker(String palavra, SeparateChainingHashST<String, Integer> hashST) {
        if (hashST.contains(palavra) || palavra.length() < 8) {
            return "Fraca";
        } else {
            String[] palavras = palavra.split("\\d");
            for(String split : palavras) {
                if (hashST.contains(split)) {
                    return "Fraca";
                }
            }
        }
        return "Forte";
    }

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        String filePath = Constants.FILES_PATH + args[0];
        In teste = new In(filePath);
        String[] keys = teste.readAllStrings();
        int n = keys.length;
        StdRandom.shuffle(keys);

        SeparateChainingHashST<String, Integer> hashST = new SeparateChainingHashST<String, Integer>();
        for (int i = 0; i < n; i++)
            hashST.put(keys[i], i);
        StdOut.println("Tempo total para construir a árvore: " + stopwatch.elapsedTime() + " segundos.");

        Stopwatch stopwatchGet = new Stopwatch();
        String palavras[] = {"observed", "observed2", "observed23", "obse2rved", "senha23observed", "senha123456"};
        for(String palavra : palavras) {
            StdOut.print("Você escreveu \"" + palavra + "\", e a senha eh ");
            StdOut.println(Exercicio05.passwordChecker(palavra, hashST));
            StdOut.println();
        }
        StdOut.println("Tempo total para verificar senha: " + stopwatchGet.elapsedTime() + " segundos.");
    }

}
