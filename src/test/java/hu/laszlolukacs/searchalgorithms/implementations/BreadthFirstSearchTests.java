/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.implementations;

import hu.laszlolukacs.searchalgorithms.models.Graph;
import hu.laszlolukacs.searchalgorithms.models.SymmetricDirectedGraph;
import hu.laszlolukacs.searchalgorithms.models.TestGraphBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Contains unit tests for the BreadthFirstSearch implementation.
 */
public class BreadthFirstSearchTests {

    private Graph testGraph;

    @Before
    public void setUp() {
        this.testGraph = TestGraphBuilder.getBasicTestGraph();
    }

    /**
     * Tests the BFS algorithm on the basic test graph.
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
