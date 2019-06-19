package exercicio_4_3_43;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import util.Constants;

public class Teste_BoruvkasMST {

    public class BoruvkaMST {

        private Queue<Edge> minimumSpanningTree;
        private double weight;

        public BoruvkaMST(EdgeWeightedGraph edgeWeightedGraph) {
            minimumSpanningTree = new Queue<>();

            UnionFind unionFind = new UnionFind(edgeWeightedGraph.V());

            // Repeats at most lg(V) times or until minimum spanning tree is complete
            for(int stage = 0; stage < edgeWeightedGraph.V(); stage = stage + stage) {
                if (minimumSpanningTree.size() == edgeWeightedGraph.V() - 1) {
                    break;
                }

                // For each tree in the forest, find its closest edge.
                // If edge weights are equal, ties are broken in favor of the first edge in EdgeWeightedGraph.edges()
                Edge[] closestEdges = new Edge[edgeWeightedGraph.V()];

                for(Edge edge : edgeWeightedGraph.edges()) {
                    int vertex1 = edge.either();
                    int vertex2 = edge.other(vertex1);

                    int treeIdentifier1 = unionFind.find(vertex1);
                    int treeIdentifier2 = unionFind.find(vertex2);

                    // Check if vertices are part of the same tree
                    if (treeIdentifier1 == treeIdentifier2) {
                        continue;
                    }

                    if (closestEdges[treeIdentifier1] == null || edge.weight() < closestEdges[treeIdentifier1].weight()) {
                        closestEdges[treeIdentifier1] = edge;
                    }
                    if (closestEdges[treeIdentifier2] == null || edge.weight() < closestEdges[treeIdentifier2].weight()) {
                        closestEdges[treeIdentifier2] = edge;
                    }
                }

                // Add newly discovered edges to the MST
                for(int vertex = 0; vertex < edgeWeightedGraph.V(); vertex++) {
                    Edge closestEdge = closestEdges[vertex];

                    if (closestEdge != null) {
                        int vertex1 = closestEdge.either();
                        int vertex2 = closestEdge.other(vertex1);

                        if (!unionFind.connected(vertex1, vertex2)) {
                            minimumSpanningTree.enqueue(closestEdge);
                            weight += closestEdge.weight();
                            unionFind.union(vertex1, vertex2);
                        }
                    }
                }
            }
        }

        public Iterable<Edge> edges() {
            return minimumSpanningTree;
        }

        public double weight() {
            return weight;
        }

    }

    public static void main(String[] args) {
        Stopwatch stopwatchBuild = new Stopwatch();
        String filePath = Constants.FILES_PATH + args[0];
        In arquivo = new In(filePath);

        EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(arquivo);
        StdOut.printf("Tempo total para construir: %.3f segundos", stopwatchBuild.elapsedTime());

        Stopwatch stopwatchEdges = new Stopwatch();
        Teste_BoruvkasMST.BoruvkaMST boruvkaMST =
                new Teste_BoruvkasMST().new BoruvkaMST(edgeWeightedGraph);
        for(Edge edge : boruvkaMST.edges()) {
            StdOut.println(edge);
        }
        StdOut.printf("Tempo total para construir vertices: %.3f segundos", stopwatchEdges.elapsedTime());
    }

}
