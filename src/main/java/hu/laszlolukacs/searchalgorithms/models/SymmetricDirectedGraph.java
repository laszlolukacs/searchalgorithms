/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.models;

import java.security.KeyException;
import java.util.*;

import hu.laszlolukacs.searchalgorithms.models.comparators.ComparatorById;

/**
 * Represents a graph which consists of a collection of nodes connected by
 * vertices.
 */
public class SymmetricDirectedGraph implements Graph {

    /**
     * The collection of the graph nodes.
     */
    private Map<Integer, Node> nodes;

    /**
     * The collection of the edges between the nodes.
     */
    private ArrayList<Edge> edges;

    /**
     * Initializes a new instance of the `SymmetricDirectedGraph` class.
     */
    public SymmetricDirectedGraph() {
        this.nodes = new HashMap<Integer, Node>();
        this.edges = new ArrayList<Edge>();
    }

    /**
     * Gets the (possibly empty) collection of nodes of the graph.
     *
     * @return
     */
    public Map<Integer, Node> getNodes() {
        return this.nodes;
    }

    /**
     * Gets the (possibly empty) collection of vertices of the graph.
     *
     * @return
     */
    public ArrayList<Edge> getVerticesList() {
        return edges;
    }

    /**
     * Adds a node with the specified index to the graph.
     *
     * @param node  The node to be added.
     * @param index The index of the node in the graph.
     */
    public void addNode(Node node, int index) {
        this.nodes.put(index, node);
    }

    @Override
    public boolean areNodesAdjacent(Node node1, Node node2) {
        return false;
    }

    @Override
    public List<Node> getNeighborNodes(Node node) {
        return node.getChildNodes();
    }

    /**
     * Adds the specified node to the graph.
     *
     * @param node  The node to be added.
     */
    @Override
    public void addNode(Node node) {
        this.nodes.put(node.getId(), node);
    }

    /**
     * Removes the specified node from the graph.
     *
     * @param node The node to be removed.
     */
    @Override
    public void removeNode(Node node) {
        this.nodes.remove(node.getId());
    }

    /**
     * Adds the specified edge to the graph.
     *
     * @param edge The edge to be added.
     */
    @Override
    public void addEdge(Edge edge) {
        if (!this.nodes.containsKey(edge.getFirstNodeId())) {
            throw new NullPointerException("The first node referenced by this edge is not found in the current graph.");
        }
        if (this.nodes.containsKey(edge.getOtherNodeId())) {
            throw new NullPointerException("The second node referenced by this edge is not found in the current graph.");
        }

        edges.add(edge);
        nodes.get(edge.getFirstNodeId()).getConnectedEdges().add(edge);
        nodes.get(edge.getOtherNodeId()).getConnectedEdges().add(edge);
    }

    /**
     * Removes the specified edge from the graph.
     *
     * @param edge The edge to be removed.
     */
    @Override
    public void removeEdge(Edge edge) {
        this.edges.remove(edge);
    }
}
