/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.models;

import java.util.List;

/**
 * Defines the contracts for graph implementations.
 */
public interface Graph {
    /**
     * Tests whether there is an edge from the node 1 to the node 2.
     *
     * @param node1 The first node.
     * @param node2 The second node.
     * @return True, if there is an edge from node 1 to node 2, otherwise false.
     */
    boolean areNodesAdjacent(Node node1, Node node2) throws NullPointerException;

    /**
     * Lists all nodes such that there is an edge from the specified node to the
     * returned nodes.
     *
     * @param node The origin node.
     * @return The nodes which are connected to the origin node.
     */
    List<Node> getNeighborNodes(Node node) throws NullPointerException;

    /**
     * Adds the specified node to the graph, if it is not there already.
     *
     * @param node The node to be added.
     */
    void addNode(Node node);

    /**
     * Removes the specified node from the graph, if it is there.
     *
     * @param node The node to be removed.
     */
    void removeNode(Node node) throws NullPointerException;

    /**
     * Adds the specified edge, if it is not there already;
     *
     * @param edge The edge to be added.
     */
    void addEdge(Edge edge) throws NullPointerException;

    /**
     * Removes the specified edge from the graph, if it is there.
     *
     * @param edge The edge to be removed.
     */
    void removeEdge(Edge edge) throws NullPointerException;
}
