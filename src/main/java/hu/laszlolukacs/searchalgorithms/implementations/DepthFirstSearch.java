/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.implementations;

import java.util.Collections;
import java.util.List;

import hu.laszlolukacs.searchalgorithms.models.Node;
import hu.laszlolukacs.searchalgorithms.models.Edge;
import hu.laszlolukacs.searchalgorithms.models.SymmetricDirectedGraph;
import hu.laszlolukacs.searchalgorithms.models.comparators.ComparatorById;

/**
 * Contains the implementation of the Depth-first search (DFS) algorithm.
 */
public class DepthFirstSearch extends SearchBase implements SearchAlgorithm {

	/**
	 * Initializes a new instance of the `DepthFirstSearch` class.
	 */
	public DepthFirstSearch() {
		super();
	}

	/**
	 * Executes the Depth-first search algorithm.
	 * 
	 * @param graph
	 *            The target graph on which the algorithm will work.
	 * @param startNodeId
	 *            The identifier of the starting node.
	 * @param targetNodeIds
	 *            The identifier of the target nodes.
	 * @return A (possibly empty) collection of the search results.
	 */
	public List<Integer> execute(final SymmetricDirectedGraph graph, final Integer startNodeId, final List<Integer> targetNodeIds) {
		List<Node> _nodes = graph.getNodesList();
		int i = 1;
		Node currentNode = (Node) _nodes.get(startNodeId - 1);

		System.out.println("*****\nExecuting Depth-first search...\n*****");

		_open.add(currentNode);
		currentNode.setHasBeenProcessed(true);

		while (!_open.isEmpty()) {
			System.out.println("X After step: " + i);

			currentNode = (Node) _open.remove();
			currentNode.setHasBeenVisited(true);
			_closed.add(currentNode);

			System.out.println("i 'Closed' array contains:");
			for (Node n : _closed) {
				System.out.print(n.getId() + ", ");
			}

			System.out.println();

			if (currentNode.getEndingPointAttribute()) {
				System.out.println("! Result found: " + currentNode.getId() + " STOPPED.");
				_results.addLast(currentNode.getId());
				return;
			} else {
				for (Edge v : currentNode.getConnectedEdges()) {
					if (v.getFirstNodeId() == currentNode.getId()) {
						if (!_nodes.get(v.getOtherNodeId() - 1).getHasBeenProcessed()
								&& !_nodes.get(v.getOtherNodeId() - 1).getHasBeenVisited()) {
							_nodes.get(v.getOtherNodeId() - 1).setParentNode(currentNode);
							currentNode.getChildNodes().add(_nodes.get(v.getOtherNodeId() - 1));
							_nodes.get(v.getOtherNodeId() - 1).setHasBeenProcessed(true);
						}
					} else {
						if (!_nodes.get(v.getFirstNodeId() - 1).getHasBeenProcessed()
								&& !_nodes.get(v.getFirstNodeId() - 1).getHasBeenVisited()) {
							_nodes.get(v.getFirstNodeId() - 1).setParentNode(currentNode);
							currentNode.getChildNodes().add(_nodes.get(v.getFirstNodeId() - 1));
							_nodes.get(v.getFirstNodeId() - 1).setHasBeenProcessed(true);
						}
					}
				}

				if (!currentNode.getChildNodes().isEmpty()) {
					Collections.sort(currentNode.getChildNodes(), new ComparatorById());
					Collections.reverse(currentNode.getChildNodes());
					for (Node n : currentNode.getChildNodes()) {
						if (n.getHasBeenVisited() == false) {
							_open.addFirst((Node) n);
							System.out.println("Added to 'open': " + n.getId());
						}
					}
				}

				System.out.println("i 'Open' array contains: ");
				for (Node n : _open) {
					System.out.print(n.getId() + ", ");
				}

				System.out.println();
			}

			i++;
		}
	}
}