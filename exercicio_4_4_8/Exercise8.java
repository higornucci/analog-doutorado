package exercicio_4_4_8;

import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import util.Constants;

public class Exercise8 {

    public double findDiameter(EdgeWeightedDigraph edgeWeightedDigraph) {
        double diameter = Double.NEGATIVE_INFINITY;

        for(int vertex = 0; vertex < edgeWeightedDigraph.V(); vertex++) {
            DijkstraSP dijkstraSP = new DijkstraSP(edgeWeightedDigraph, vertex);

            for(int vertex2 = 0; vertex2 < edgeWeightedDigraph.V(); vertex2++) {
                if (dijkstraSP.distTo(vertex2) > diameter) {
                    diameter = dijkstraSP.distTo(vertex2);
                }
            }
        }

        return diameter;
    }

    public static void main(String[] args) {
        Stopwatch stopwatchBuild = new Stopwatch();
        String filePath = Constants.FILES_PATH + args[0];
        In arquivo = new In(filePath);

        EdgeWeightedDigraph edgeWeightedDigraph = new EdgeWeightedDigraph(8);
        StdOut.println();
        StdOut.printf("Tempo total para construir: %.3f segundos\n",
                      stopwatchBuild.elapsedTime());
        StdOut.println();
        StdOut.println();

        Stopwatch stopwatchDiametro = new Stopwatch();
        double diameter = new Exercise8().findDiameter(edgeWeightedDigraph);
        StdOut.println("Diametro: " + diameter);
        StdOut.printf("Tempo total para achar o diametro: %.3f segundos\n",
                      stopwatchDiametro.elapsedTime());


    }

}
