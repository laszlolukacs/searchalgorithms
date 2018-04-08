/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.implementations;

import java.util.Collections;
import java.util.List;

import hu.laszlolukacs.searchalgorithms.models.Heuristics;
import hu.laszlolukacs.searchalgorithms.models.Node;
import hu.laszlolukacs.searchalgorithms.models.Edge;
import hu.laszlolukacs.searchalgorithms.models.SymmetricDirectedGraph;
import hu.laszlolukacs.searchalgorithms.models.comparators.ComparatorCombined;

/**
 * Contains the implementation of the A* search algorithm.
 */
public class AStarSearch extends SearchBase implements SearchAlgorithm {

	private int _heuristicId;
//	private ArrayList<Node> _destinations;

	/**
	 * Initializes a new instance of the `AStarSearch` class.
	 * 
	 * @param vertices
	 *            The vertices on which the search algorithm will be executed.
	 * @param nodes
	 *            The nodes on which the search algorithm will be executed.
	 * @param destinations
	 *            The destination nodes.
	 * @param heuristicId
	 *            The identifier of the heuristic method.
	 */
	public AStarSearch(int heuristicId) {
		super();
		this._heuristicId = heuristicId;
//		this._destinations = destinations;
	}

	/**
	 * Executes the A* search algorithm.
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

		switch (_heuristicId) {
		case 1:
			System.out.println("*****\nExecuting A* search with constant 0 heuristics\n*****");
			break;
		case 2:
			System.out.println("*****\nExecuting A* search with Manhattan distance heuristics\n*****");
			break;
		case 3:
			System.out.println("*****\nExecuting A* search with Displacement distance heuristics\n*****");
			break;
		}

		_open.add(currentNode);
		currentNode.setHasBeenProcessed(true);

		while (!_open.isEmpty()) {
			System.out.println("X After step: " + i);

			currentNode = (Node) _open.remove();
			currentNode.setHasBeenVisited(true);
			_closed.add(currentNode);

			System.out.println("i 'Closed' node:");
			for (Node n : _closed) {
				System.out.print(n.getId() + " (" + n.getHeuristicDistance() + "+" + n.getDistance() + "), ");
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
							_nodes.get(v.getOtherNodeId() - 1).setDistance(currentNode.getDistance() + v.getCost());
							_nodes.get(v.getOtherNodeId() - 1).setHeuristicDistance(Heuristics.calculate(_destinations,
									_nodes.get(v.getOtherNodeId() - 1), _heuristicId));
							currentNode.getChildNodes().add(_nodes.get(v.getOtherNodeId() - 1));
							_nodes.get(v.getOtherNodeId() - 1).setHasBeenProcessed(true);
						}
					} else {
						if (!_nodes.get(v.getFirstNodeId() - 1).getHasBeenProcessed()
								&& !_nodes.get(v.getFirstNodeId() - 1).getHasBeenVisited()) {
							_nodes.get(v.getFirstNodeId() - 1).setParentNode(currentNode);
							_nodes.get(v.getFirstNodeId() - 1).setDistance(currentNode.getDistance() + v.getCost());
							_nodes.get(v.getFirstNodeId() - 1).setHeuristicDistance(Heuristics.calculate(_destinations,
									_nodes.get(v.getFirstNodeId() - 1), _heuristicId));
							currentNode.getChildNodes().add(_nodes.get(v.getFirstNodeId() - 1));
							_nodes.get(v.getFirstNodeId() - 1).setHasBeenProcessed(true);
						}
					}
				}
				
				if (!currentNode.getChildNodes().isEmpty()) {
					Collections.sort(currentNode.getChildNodes(), new ComparatorCombined());
					for (Node n : currentNode.getChildNodes()) {
						if (n.getHasBeenVisited() == false) {
							_open.add((Node) n);
							System.out.println("Added to 'Open': " + n.getId() + " (" + n.getHeuristicDistance() + "+"
									+ n.getDistance() + ")");
						}
					}
				}
				
				Collections.sort(_open, new ComparatorCombined());

				System.out.println("i 'Open' array contains: ");
				for (Node n : _open) {
					System.out.print(n.getId() + " (" + n.getHeuristicDistance() + "+" + n.getDistance() + "), ");
				}
				
				System.out.println();
			}
			
			i++;
		}
	}
}
