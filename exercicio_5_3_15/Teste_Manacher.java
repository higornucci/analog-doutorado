package exercicio_5_3_15;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import util.ArrayGenerator;

public class Teste_Manacher {

    private void doExperiment(int textLength, int experiments) {
        for(int experiment = 0; experiment < experiments; experiment++) {
            String randomText = ArrayGenerator.generateRandomStringOfSpecifiedLength(textLength);

            Manacher manacher = new Manacher(randomText);
            manacher.longestPalindromicSubstring();
        }
    }

    // Parameters example: 100000 100
    // Parameters example: 100000 1000
    // Parameters example: 100000 5000
    public static void main(String[] args) {
        Stopwatch stopwatchSearch = new Stopwatch();
        int textLength = Integer.parseInt(args[0]);
        int experiments = Integer.parseInt(args[1]);

        new Teste_Manacher().doExperiment(textLength, experiments);
        StdOut.printf("Tempo total para procurar: %.3f segundos\n",
                      stopwatchSearch.elapsedTime());
    }

}
