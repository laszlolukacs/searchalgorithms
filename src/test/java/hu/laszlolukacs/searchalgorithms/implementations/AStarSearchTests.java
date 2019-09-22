package hu.laszlolukacs.searchalgorithms.implementations;

import hu.laszlolukacs.searchalgorithms.models.Graph;
import hu.laszlolukacs.searchalgorithms.models.TestGraphBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class AStarSearchTests {

    private Graph testGraph;

    @Before
    public void setUp() {
        this.testGraph = TestGraphBuilder.getBasicTestGraph();
    }

    /**
     * Tests the A* search algorithm with constant 0 heuristic on the basic test graph.
     */
    @Test
    public void testExecuteWithConstant0Heuristic() {
        List<Integer> goals = new ArrayList<Integer>();
        goals.add(10);
        goals.add(12);
        SearchBase algorithmUnderTest = new AStarSearch(1);
        List<Integer> results = algorithmUnderTest.execute(this.testGraph, 1, goals);
        List<Integer> expectedResults = new ArrayList<Integer>();
        expectedResults.add(1);
        expectedResults.add(11);
        expectedResults.add(12);
        assertArrayEquals(expectedResults.toArray(), results.toArray());
    }

    /**
     * Tests the A* search algorithm with Manhattan distance heuristic on the basic test graph.
     */
    @Test
    public void testExecuteWithManhattanDistanceHeuristic() {
        List<Integer> goals = new ArrayList<Integer>();
        goals.add(10);
        goals.add(12);
        SearchBase algorithmUnderTest = new AStarSearch(2);
        List<Integer> results = algorithmUnderTest.execute(this.testGraph, 1, goals);
        List<Integer> expectedResults = new ArrayList<Integer>();
        expectedResults.add(1);
        expectedResults.add(11);
        expectedResults.add(12);
        assertArrayEquals(expectedResults.toArray(), results.toArray());
    }

    /**
     * Tests the A* search algorithm with Euclidean distance heuristic on the basic test graph.
     */
    @Test
    public void testExecuteWithEuclideanDistanceHeuristic() {
        List<Integer> goals = new ArrayList<Integer>();
        goals.add(10);
        goals.add(12);
        SearchBase algorithmUnderTest = new AStarSearch(3);
        List<Integer> results = algorithmUnderTest.execute(this.testGraph, 1, goals);
        List<Integer> expectedResults = new ArrayList<Integer>();
        expectedResults.add(1);
        expectedResults.add(11);
        expectedResults.add(12);
        assertArrayEquals(expectedResults.toArray(), results.toArray());
    }
}
