/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.models;

import java.util.ArrayList;
import java.util.Collections;

import hu.laszlolukacs.searchalgorithms.models.comparators.ComparatorById;

/**
 * Represents a graph which consists of a collection of nodes connected by
 * vertices.
 */
public class Graph {

	/**
	 * The collection of the graph nodes.
	 */
	private ArrayList<Node> nodes;

	/**
	 * The collection of the edges between the nodes.
	 */
	private ArrayList<Edge> edges;
	
	/**
	 * Initializes a new instance of the `Graph` class.
	 */
	public Graph() {
		this.nodes = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
	}

	/**
	 * Gets the (possibly empty) collection of nodes of the graph.
	 * 
	 * @return
	 */
	public ArrayList<Node> getNodesList() {
		return nodes;
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
	 * @param node
	 *            The node to be added.
	 * @param index
	 *            The index of the node in the graph.
	 */
	public void addNode(Node node, int index) {
		this.nodes.add(index, node);
	}

	/**
	 * Adds an edge to the graph.
	 * 
	 * @param edge
	 *            The edge to be added.
	 */
	public void addEdge(Edge edge) {
		edges.add(edge);
		nodes.get(edge.getFirstNodeId() - 1).getConnectedEdges().add(edge);
		nodes.get(edge.getOtherNodeId() - 1).getConnectedEdges().add(edge);
	}

	/**
	 * Sorts the nodes of the graph by their identifiers.
	 */
	public void sortNodes() {
		Collections.sort(this.nodes, new ComparatorById());
	}
}
