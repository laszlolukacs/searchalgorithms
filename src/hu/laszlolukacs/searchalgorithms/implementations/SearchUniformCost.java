/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.implementations;

import java.util.ArrayList;
import java.util.Collections;

import hu.laszlolukacs.searchalgorithms.models.Node;
import hu.laszlolukacs.searchalgorithms.models.Vertex;
import hu.laszlolukacs.searchalgorithms.models.comparators.ComparatorByDistance;

/**
 * Contains the implementation of the Uniform cost search algorithm.
 */
public class SearchUniformCost extends SearchBase implements SearchAlgorithm {

	/**
	 * Initializes a new instance of the `SearchUniformCost` class.
	 * 
	 * @param vertices
	 *            The vertices on which the search algorithm will be executed.
	 * @param nodes
	 *            The nodes on which the search algorithm will be executed.
	 */
	public SearchUniformCost(ArrayList<Vertex> vertices, ArrayList<Node> nodes) {
		super(vertices, nodes);
	}

	/**
	 * Executes the Uniform cost search algorithm.
	 */
	public void execute() {
		int i = 1;
		Node currentNode = (Node) _nodes.get(_startId - 1);

		System.out.println("*****\nExecuting Uniform cost search...\n*****");

		_open.add(currentNode);
		currentNode.setHasBeenProcessed(true);

		while (!_open.isEmpty()) {
			System.out.println("X After step: " + i);

			currentNode = (Node) _open.remove();
			currentNode.setHasBeenVisited(true);
			_closed.add(currentNode);

			System.out.println("i 'Closed' array contains:");
			for (Node n : _closed) {
				System.out.print(n.getId() + " (" + n.getDistance() + "), ");
			}
			
			System.out.println();

			if (currentNode.getEndingPointAttribute()) {
				System.out.println("! Result found: " + currentNode.getId() + " STOPPED.");
				_results.addLast(currentNode.getId());
				return;
			} else {
				for (Vertex v : currentNode.getConnectedVertices()) {
					if (v.getFirstNodeId() == currentNode.getId()) {
						if (!_nodes.get(v.getOtherNodeId() - 1).getHasBeenProcessed()
								&& !_nodes.get(v.getOtherNodeId() - 1).getHasBeenVisited()) {
							_nodes.get(v.getOtherNodeId() - 1).setParentNode(currentNode);
							_nodes.get(v.getOtherNodeId() - 1).setDistance(currentNode.getDistance() + v.getCost());
							currentNode.getChildNodes().add(_nodes.get(v.getOtherNodeId() - 1));
							_nodes.get(v.getOtherNodeId() - 1).setHasBeenProcessed(true);
						}
					} else {
						if (!_nodes.get(v.getFirstNodeId() - 1).getHasBeenProcessed()
								&& !_nodes.get(v.getFirstNodeId() - 1).getHasBeenVisited()) {
							_nodes.get(v.getFirstNodeId() - 1).setParentNode(currentNode);
							_nodes.get(v.getFirstNodeId() - 1).setDistance(currentNode.getDistance() + v.getCost());
							currentNode.getChildNodes().add(_nodes.get(v.getFirstNodeId() - 1));
							_nodes.get(v.getFirstNodeId() - 1).setHasBeenProcessed(true);
						}
					}
				}
				
				if (!currentNode.getChildNodes().isEmpty()) {
					Collections.sort(currentNode.getChildNodes(), new ComparatorByDistance());
					for (Node n : currentNode.getChildNodes()) {
						if (n.getHasBeenVisited() == false) {
							_open.add((Node) n);
							System.out.println("Added to 'Open': " + n.getId() + " (" + n.getDistance() + ")");
						}
					}
				}
				
				Collections.sort(_open, new ComparatorByDistance());

				System.out.println("i 'Open' array contains: ");
				for (Node n : _open) {
					System.out.print(n.getId() + " (" + n.getDistance() + "), ");
				}
				
				System.out.println();
			}
			
			i++;
		}
	}
}
