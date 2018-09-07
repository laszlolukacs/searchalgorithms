/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a symmetric, directed graph which consists of a collection of nodes connected by
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
     * Gets the (possibly empty) collection of the nodes of the graph.
     *
     * @return The collection of the nodes of the graph.
     */
    public Map<Integer, Node> getNodes() {
        return this.nodes;
    }

    /**
     * Gets the (possibly empty) collection of edges of the graph.
     *
     * @return The collection of the edges of the graph.
     */
    public ArrayList<Edge> getEdgeList() {
        return this.edges;
    }

    /**
     * Tests whether there is an edge from the node 1 to the node 2.
     *
     * @param node1 The first node.
     * @param node2 The second node.
     * @return True, if there is an edge from node 1 to node 2, otherwise false.
     */
    @Override
    public boolean areNodesAdjacent(Node node1, Node node2) throws NullPointerException {
        for (Edge edge : this.edges) {
            if ((edge.getFirstNodeId() == node1.getId() && edge.getOtherNodeId() == node2.getId())
                    || (edge.getFirstNodeId() == node2.getId() && edge.getOtherNodeId() == node1.getId())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Lists all nodes such that there is an edge from the specified node to the
     * returned nodes.
     *
     * @param node The origin node.
     * @return The nodes which are connected to the origin node.
     */
    @Override
    public List<Node> getNeighborNodes(Node node) throws NullPointerException {
        List<Node> neighborNodes = new ArrayList<Node>();
        for (Edge edge : node.getConnectedEdges()) {
            if (edge.getFirstNodeId() == node.getId()) {
                neighborNodes.add(edge.getOtherNode());
            } else {
                neighborNodes.add(edge.getFirstNode());
            }
        }

        return neighborNodes;
    }

    /**
     * Adds the specified node to the graph.
     *
     * @param node The node to be added.
     */
    @Override
    public void addNode(Node node) {
        this.nodes.put(node.getId(), node);
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

    /**
     * Removes the specified node (and any edges connected to it) from the graph.
     *
     * @param node The node to be removed.
     */
    @Override
    public void removeNode(Node node) throws NullPointerException {
        // removes all the connected edges as well
        for (Edge edge : new ArrayList<Edge>(node.getConnectedEdges())) {
            this.removeEdge(edge);
        }

        this.nodes.remove(node.getId());
    }

    /**
     * Adds the specified edge to the graph.
     *
     * @param edge The edge to be added.
     */
    @Override
    public void addEdge(Edge edge) throws NullPointerException {
        if (!this.nodes.containsKey(edge.getFirstNodeId())) {
            throw new NullPointerException("The first node referenced by this edge is not found in the current graph.");
        }
        if (!this.nodes.containsKey(edge.getOtherNodeId())) {
            throw new NullPointerException("The second node referenced by this edge is not found in the current graph.");
        }

        if (edge.getFirstNode() == null || edge.getOtherNode() == null) {
            Edge edgeToBeAdded = new Edge(this.nodes.get(edge.getFirstNodeId()), this.nodes.get(edge.getOtherNodeId()), edge.getCost());
            edge = edgeToBeAdded;
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
    public void removeEdge(Edge edge) throws NullPointerException {
        this.edges.remove(edge);
        nodes.get(edge.getFirstNodeId()).getConnectedEdges().remove(edge);
        nodes.get(edge.getOtherNodeId()).getConnectedEdges().remove(edge);
    }
}
