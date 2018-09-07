package hu.laszlolukacs.searchalgorithms.implementations;

import hu.laszlolukacs.searchalgorithms.models.Edge;
import hu.laszlolukacs.searchalgorithms.models.Graph;
import hu.laszlolukacs.searchalgorithms.models.Node;
import hu.laszlolukacs.searchalgorithms.models.SymmetricDirectedGraph;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Contains unit tests for the BreadthFirstSearch implementation.
 */
public class BreadthFirstSearchTest {
    /**
     * The graph used for the test.
     */
    private Graph testGraph;

    /**
     * Prepares the test environment.
     */
    @Before
    public void setUp() {
        this.testGraph = new SymmetricDirectedGraph();
        this.testGraph.addNode(new Node(1, "1", 0, 0));
        this.testGraph.addNode(new Node(2, "2", 1, 0));
        this.testGraph.addNode(new Node(3, "3", 2, 0));
        this.testGraph.addNode(new Node(4, "4", 3, 0));
        this.testGraph.addNode(new Node(5, "5", 4, 0));
        this.testGraph.addNode(new Node(6, "6", 5, 0));
        this.testGraph.addNode(new Node(7, "7", 6, 0));
        this.testGraph.addNode(new Node(8, "8", 7, 0));
        this.testGraph.addNode(new Node(9, "9", 8, 0));
        this.testGraph.addNode(new Node(10, "10", 9, 0));
        this.testGraph.addNode(new Node(11, "11", 0, 1));
        this.testGraph.addNode(new Node(12, "12", 0, 2));

        this.testGraph.addEdge(new Edge(1, 2, 1));
        this.testGraph.addEdge(new Edge(2, 3, 1));
        this.testGraph.addEdge(new Edge(3, 4, 1));
        this.testGraph.addEdge(new Edge(4, 5, 1));
        this.testGraph.addEdge(new Edge(5, 6, 1));
        this.testGraph.addEdge(new Edge(6, 7, 1));
        this.testGraph.addEdge(new Edge(7, 8, 1));
        this.testGraph.addEdge(new Edge(8, 9, 1));
        this.testGraph.addEdge(new Edge(9, 10, 1));
        this.testGraph.addEdge(new Edge(1, 11, 1));
        this.testGraph.addEdge(new Edge(11, 12, 1));
    }

    /**
     * Tests the BFS algorithm on the test graph.
     */
    @Test
    public void testExecute() {
        List<Integer> goals = new ArrayList<Integer>();
        goals.add(10);
        goals.add(12);
        SearchBase algorithmUnderTest = new BreadthFirstSearch();
        List<Integer> results = algorithmUnderTest.execute((SymmetricDirectedGraph) this.testGraph, 1, goals);
        List<Integer> expectedResults = new ArrayList<Integer>();
        expectedResults.add(1);
        expectedResults.add(11);
        expectedResults.add(12);
        assertArrayEquals(expectedResults.toArray(), results.toArray());
    }
}
