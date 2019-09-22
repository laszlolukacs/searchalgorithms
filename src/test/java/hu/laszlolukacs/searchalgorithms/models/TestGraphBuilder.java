/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.models;

/**
 * Supplies a default test graph for the unit tests of the search algorithms.
 */
public class TestGraphBuilder {

    /**
     * Builds the basic, complete test graph.
     *
     * @return A complete basic test graph, containing some nodes and edges between them.
     */
    public static Graph getBasicTestGraph() {
        Graph testGraph = new SymmetricDirectedGraph();
        TestGraphBuilder.addNodesToBasicTestGraph(testGraph);
        TestGraphBuilder.addEdgesToBasicTestGraph(testGraph);
        return testGraph;
    }

    private static void addNodesToBasicTestGraph(Graph graph) {
        graph.addNode(new Node(1, "1", 0, 0));
        graph.addNode(new Node(2, "2", 1, 0));
        graph.addNode(new Node(3, "3", 2, 0));
        graph.addNode(new Node(4, "4", 3, 0));
        graph.addNode(new Node(5, "5", 4, 0));
        graph.addNode(new Node(6, "6", 5, 0));
        graph.addNode(new Node(7, "7", 6, 0));
        graph.addNode(new Node(8, "8", 7, 0));
        graph.addNode(new Node(9, "9", 8, 0));
        graph.addNode(new Node(10, "10", 9, 0));
        graph.addNode(new Node(11, "11", 0, 1));
        graph.addNode(new Node(12, "12", 0, 2));
    }

    private static void addEdgesToBasicTestGraph(Graph graph) {
        graph.addEdge(new Edge(1, 2, 1));
        graph.addEdge(new Edge(2, 3, 1));
        graph.addEdge(new Edge(3, 4, 1));
        graph.addEdge(new Edge(4, 5, 1));
        graph.addEdge(new Edge(5, 6, 1));
        graph.addEdge(new Edge(6, 7, 1));
        graph.addEdge(new Edge(7, 8, 1));
        graph.addEdge(new Edge(8, 9, 1));
        graph.addEdge(new Edge(9, 10, 1));
        graph.addEdge(new Edge(1, 11, 1));
        graph.addEdge(new Edge(11, 12, 1));
    }
}
