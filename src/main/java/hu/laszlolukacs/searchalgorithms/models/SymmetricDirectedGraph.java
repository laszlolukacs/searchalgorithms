/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import hu.laszlolukacs.searchalgorithms.models.comparators.ComparatorById;

/**
 * Represents a graph which consists of a collection of nodes connected by
 * vertices.
 */
public class SymmetricDirectedGraph {

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
	 * @param node
	 *            The node to be added.
	 * @param index
	 *            The index of the node in the graph.
	 */
	public void addNode(Node node, int index) {
		this.nodes.put(index, node);
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
}
