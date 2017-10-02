/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.implementations;

import java.util.ArrayList;
import java.util.Collections;

import hu.laszlolukacs.searchalgorithms.ComparatorHeuristic;
import hu.laszlolukacs.searchalgorithms.models.Heuristics;
import hu.laszlolukacs.searchalgorithms.models.Node;
import hu.laszlolukacs.searchalgorithms.models.Vertex;

/**
 * Contains the implementation of the Greedy (best-first) search algorithm.
 */
public class SearchGreedy extends SearchBase implements SearchAlgorithm {

	private byte _heuristicId;
	private ArrayList<Node> _destinations;

	/**
	 * Initializes a new instance of the `SearchGreedy` class.
	 * 
	 * @param vertices
	 *            The vertices on which the search algorithm will be executed.
	 * @param nodes
	 *            The nodes on which the search algorithm will be executed.
	 * @param destinations
	 *            The destination nodes
	 * @param heuristicId
	 *            The identifier of the heuristic method.
	 */
	public SearchGreedy(ArrayList<Vertex> vertices, ArrayList<Node> nodes, ArrayList<Node> destinations,
			byte heuristicId) {
		super(vertices, nodes);
		this._heuristicId = heuristicId;
		this._destinations = destinations;
	}

	/**
	 * Executes the Greedy search algorithm.
	 */
	public void execute() {
		int i = 1;
		Node currentNode = (Node) _nodes.get(_startId - 1);

		switch (_heuristicId) {
		case 1:
			System.out.println("*****\nExecuting Greedy search with constant 0 heuristics\n*****");
			break;
		case 2:
			System.out.println("*****\nExecuting Greedy search with Manhattan distance heuristics\n*****");
			break;
		case 3:
			System.out.println("*****\nExecuting Greedy search with Displacement distance heuristics\n*****");
			break;
		}

		_open.add(currentNode);
		currentNode.setHasBeenProcessed(true);

		while (!_open.isEmpty()) {
			System.out.println("X After step: " + i);

			currentNode = (Node) _open.remove();
			currentNode.setHasBeenVisited(true);
			_closed.add(currentNode);

			System.out.println("i 'Closed' array contains:");
			for (Node n : _open) {
				System.out.print(n.getId() + " (" + n.getHeuristicDistance() + "), ");
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
							// _nodes.get(v.getOtherEndId() -
							// 1).setDistance(currentNode.getDistance() +
							// v.getCost());
							_nodes.get(v.getOtherNodeId() - 1).setHeuristicDistance(Heuristics.calculate(_destinations,
									_nodes.get(v.getOtherNodeId() - 1), _heuristicId));
							currentNode.getChildNodes().add(_nodes.get(v.getOtherNodeId() - 1));
							_nodes.get(v.getOtherNodeId() - 1).setHasBeenProcessed(true);
						}
					} else {
						if (!_nodes.get(v.getFirstNodeId() - 1).getHasBeenProcessed()
								&& !_nodes.get(v.getFirstNodeId() - 1).getHasBeenVisited()) {
							_nodes.get(v.getFirstNodeId() - 1).setParentNode(currentNode);
							// _nodes.get(v.getFirstEndId() -
							// 1).setDistance(currentNode.getDistance() +
							// v.getCost());
							_nodes.get(v.getFirstNodeId() - 1).setHeuristicDistance(Heuristics.calculate(_destinations,
									_nodes.get(v.getFirstNodeId() - 1), _heuristicId));
							currentNode.getChildNodes().add(_nodes.get(v.getFirstNodeId() - 1));
							_nodes.get(v.getFirstNodeId() - 1).setHasBeenProcessed(true);
						}
					}
				}

				if (!currentNode.getChildNodes().isEmpty()) {
					Collections.sort(currentNode.getChildNodes(), new ComparatorHeuristic());
					for (Node n : currentNode.getChildNodes()) {
						if (n.getHasBeenVisited() == false) {
							_open.add((Node) n);
							System.out.println("Added to 'Open': " + n.getId() + " (" + n.getHeuristicDistance() + ")");
						}
					}
				}

				Collections.sort(_open, new ComparatorHeuristic());

				System.out.println("i 'Open' array contains: ");
				for (Node n : _open) {
					System.out.print(n.getId() + " (" + n.getHeuristicDistance() + "), ");
				}

				System.out.println();
			}

			i++;
		}
	}
}
