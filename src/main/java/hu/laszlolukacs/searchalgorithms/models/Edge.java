/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.models;

/**
 * Represents an edge between the nodes in a graph, which always has a predefined cost.
 */
public class Edge {

    // The first node connected by this edge.
    private Node firstNode;

    // The other node connected by this edge.
    private Node otherNode;

    // The identifier of the first node connected by this edge.
    private int firstNodeId;

    // The identifier of the other node connected by this edge.
    private int otherNodeId;

    // The cost assigned to this edge.
    private int cost;

    /**
     * Initializes a new instance of the `Edge` class.
     *
     * @param firstNodeId The identifier of the first node.
     * @param otherNodeId The identifier of the other node.
     * @param cost        The cost of the edge.
     */
    public Edge(int firstNodeId, int otherNodeId, int cost) {
        this.firstNodeId = firstNodeId;
        this.otherNodeId = otherNodeId;
        this.cost = cost;
    }

    /**
     * Initializes a new instance of the `Edge` class.
     *
     * @param firstNode The first node.
     * @param otherNode The other node.
     * @param cost      The cost of the vertex.
     */
    public Edge(Node firstNode, Node otherNode, int cost) {
        this.firstNode = firstNode;
        this.firstNodeId = firstNode.getId();
        this.otherNode = otherNode;
        this.otherNodeId = otherNode.getId();
        this.cost = cost;
    }

    /**
     * Parses an edge from its string representation.
     *
     * @param firstNodeId The identifier of the first node.
     * @param otherNodeId The identifier of the other node.
     * @param cost        The cost of the edge.
     * @return A parsed edge.
     * @throws NumberFormatException The input string was not a proper number.
     */
    public static Edge parseFromStrings(String firstNodeId, String otherNodeId, String cost) throws NumberFormatException {
        return new Edge(Integer.parseInt(firstNodeId), Integer.parseInt(otherNodeId), Integer.parseInt(cost));
    }

    /**
     * Gets a reference for the first node to which vertex is connected.
     *
     * @return Reference for the first node.
     */
    public Node getFirstNode() {
        return firstNode;
    }

    /**
     * Gets a reference for the other node to which vertex is connected.
     *
     * @return Reference for the other node.
     */
    public Node getOtherNode() {
        return otherNode;
    }

    /**
     * Gets the identifier of the first node to which this vertex is connected.
     *
     * @return The identifier of the first node.
     */
    public int getFirstNodeId() {
        return firstNodeId;
    }

    /**
     * Gets the identifier of the other node to which this vertex is connected.
     *
     * @return The identifier of the other node.
     */
    public int getOtherNodeId() {
        return otherNodeId;
    }

    /**
     * Gets the cost of this vertex.
     *
     * @return The cost of the vertex.
     */
    public int getCost() {
        return cost;
    }
}
