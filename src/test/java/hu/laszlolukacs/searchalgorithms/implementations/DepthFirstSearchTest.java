/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.implementations;

import hu.laszlolukacs.searchalgorithms.models.Graph;
import hu.laszlolukacs.searchalgorithms.models.TestGraphBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Contains unit tests for the DepthFirstSearch implementation.
 */
public class DepthFirstSearchTest {

    /**
     * The graph used for the test.
     */
    private Graph testGraph;

    /**
     * Prepares the test environment.
     */
    @Before
    public void setUp() {
        this.testGraph = TestGraphBuilder.build();
    }

    /**
     * Tests the DFS algorithm on the test graph.
     */
    @Test
    public void testExecute() {
        List<Integer> goals = new ArrayList<Integer>();
        goals.add(10);
        goals.add(12);
        SearchBase algorithmUnderTest = new DepthFirstSearch();
        List<Integer> results = algorithmUnderTest.execute(this.testGraph, 1, goals);
        List<Integer> expectedResults = new ArrayList<Integer>();
        expectedResults.add(1);
        expectedResults.add(2);
        expectedResults.add(3);
        expectedResults.add(4);
        expectedResults.add(5);
        expectedResults.add(6);
        expectedResults.add(7);
        expectedResults.add(8);
        expectedResults.add(9);
        expectedResults.add(10);
        assertArrayEquals(expectedResults.toArray(), results.toArray());
    }
}
