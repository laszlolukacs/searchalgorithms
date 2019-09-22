/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Contains unit tests for the SymmetricDirectedGraph implementation.
 */
public class SymmetricDirectedGraphTest {

    private Graph graphUnderTest = new SymmetricDirectedGraph();

    @Before
    public void setUp() {
        this.graphUnderTest = new SymmetricDirectedGraph();
    }

    @Test
    public void testAdjacent() {
        Node firstNode = new Node(1, "", 1, 1);
        Node secondNode = new Node(2, "", 1, 2);
        Edge edge = new Edge(firstNode, secondNode, 1);

        this.graphUnderTest.addNode(firstNode);
        this.graphUnderTest.addNode(secondNode);
        this.graphUnderTest.addEdge(edge);
        boolean adjacency = this.graphUnderTest.adjacent(firstNode, secondNode);
        assertTrue(adjacency);
    }

    @Test
    public void testAdjacentNotTrue() {
        Node firstNode = new Node(1, "", 1, 1);
        Node otherNode = new Node(2, "", 1, 2);

        this.graphUnderTest.addNode(firstNode);
        this.graphUnderTest.addNode(otherNode);
        boolean adjacency = this.graphUnderTest.adjacent(firstNode, otherNode);
        assertFalse(adjacency);
    }

    @Test
    public void testNeighbors() {
        Node firstNode = new Node(1, "", 1, 1);
        Node otherNode1 = new Node(2, "", 1, 2);
        Node otherNode2 = new Node(3, "", 2, 1);
        List<Node> neighborNodes = new ArrayList<Node>();
        neighborNodes.add(otherNode1);
        neighborNodes.add(otherNode2);

        this.graphUnderTest.addNode(firstNode);
        for (Node node : neighborNodes) {
            Edge edge = new Edge(firstNode, node, 1);
            this.graphUnderTest.addNode(node);
            this.graphUnderTest.addEdge(edge);
        }

        List<Node> neighboringNodes = this.graphUnderTest.neighbors(firstNode);
        assertArrayEquals(neighborNodes.toArray(), neighboringNodes.toArray());
    }

    @Test
    public void testAddNode() {
        Node nodeToBeAdded = new Node(1, "", 1, 1);
        this.graphUnderTest.addNode(nodeToBeAdded);
        boolean isNodePresent = ((SymmetricDirectedGraph) this.graphUnderTest).getNodes().containsValue(nodeToBeAdded);
        assertTrue(isNodePresent);
    }

    @Test
    public void testRemoveNode() {
        Node nodeToBeAdded = new Node(1, "", 1, 1);
        this.graphUnderTest.addNode(nodeToBeAdded);
        this.graphUnderTest.removeNode(nodeToBeAdded);
        boolean isNodePresent = ((SymmetricDirectedGraph) this.graphUnderTest).getNodes().containsValue(nodeToBeAdded);
        assertFalse(isNodePresent);
    }

    @Test
    public void testRemoveNodeWithEdges() {
        Node firstNode = new Node(1, "", 1, 1);
        Node nodeToRemove = new Node(2, "", 1, 2);
        Edge edgeToRemove = new Edge(firstNode, nodeToRemove, 1);

        this.graphUnderTest.addNode(firstNode);
        this.graphUnderTest.addNode(nodeToRemove);
        this.graphUnderTest.addEdge(edgeToRemove);
        this.graphUnderTest.removeNode(nodeToRemove);
        boolean isNodePresent = ((SymmetricDirectedGraph) this.graphUnderTest).getNodes().containsValue(nodeToRemove);
        assertFalse(isNodePresent);

        boolean isEdgePresent = ((SymmetricDirectedGraph) this.graphUnderTest).getEdgeList().contains(edgeToRemove);
        assertFalse(isEdgePresent);
    }

    @Test
    public void testAddEdge() {
        Node firstNode = new Node(1, "", 1, 1);
        Node secondNode = new Node(2, "", 1, 2);
        Edge edge = new Edge(firstNode, secondNode, 1);

        this.graphUnderTest.addNode(firstNode);
        this.graphUnderTest.addNode(secondNode);
        this.graphUnderTest.addEdge(edge);
        boolean isEdgePresent = ((SymmetricDirectedGraph) this.graphUnderTest).getEdgeList().contains(edge);
        assertTrue(isEdgePresent);
    }

    @Test
    public void testRemoveEdge() {
        Node firstNode = new Node(1, "", 1, 1);
        Node secondNode = new Node(2, "", 1, 2);
        Edge edge = new Edge(firstNode, secondNode, 1);

        this.graphUnderTest.addNode(firstNode);
        this.graphUnderTest.addNode(secondNode);
        this.graphUnderTest.addEdge(edge);
        this.graphUnderTest.removeEdge(edge);
        boolean isEdgePresent = ((SymmetricDirectedGraph) this.graphUnderTest).getEdgeList().contains(edge);
        assertFalse(isEdgePresent);
    }
}
