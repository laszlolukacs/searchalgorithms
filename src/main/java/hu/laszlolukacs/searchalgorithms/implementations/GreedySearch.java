/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.implementations;

import java.util.Collections;
import java.util.List;

import hu.laszlolukacs.searchalgorithms.models.*;
import hu.laszlolukacs.searchalgorithms.models.comparators.ComparatorHeuristic;

/**
 * Contains the implementation of the Greedy (best-first) search algorithm.
 */
public class GreedySearch extends SearchBase implements SearchAlgorithm {

	private int _heuristicId;
//	private ArrayList<Node> _destinations;

	/**
	 * Initializes a new instance of the `GreedySearch` class.
	 *
	 * @param vertices
	 *            The vertices on which the search algorithm will be executed.
	 * @param nodes
	 *            The nodes on which the search algorithm will be executed.
	 * @param destinations
	 *            The destination nodes
	 * @param heuristicsId
	 *            The identifier of the heuristic method.
	 */
	public GreedySearch(int heuristicsId) {
		super();
		this._heuristicId = heuristicsId;
//		this._destinations = destinations;
	}

//	/**
//	 * Executes the Greedy search algorithm.
//	 *
//	 * @param graph
//	 *            The target graph on which the algorithm will work.
//	 * @param searchKeyNodeId
//	 *            The identifier of the starting node.
//	 * @param targetNodeIds
//	 *            The identifier of the target nodes.
//	 * @return A (possibly empty) collection of the search results.
//	 */
//	public List<Integer> execute(final SymmetricDirectedGraph graph, final Integer searchKeyNodeId, final List<Integer> targetNodeIds) {
//		List<Node> _nodes = graph.getNodesList();
//		int i = 1;
//		Node currentNode = (Node) _nodes.get(searchKeyNodeId - 1);
//
//		switch (_heuristicId) {
//		case 1:
//			System.out.println("*****\nExecuting Greedy search with constant 0 heuristics\n*****");
//			break;
//		case 2:
//			System.out.println("*****\nExecuting Greedy search with Manhattan distance heuristics\n*****");
//			break;
//		case 3:
//			System.out.println("*****\nExecuting Greedy search with Displacement distance heuristics\n*****");
//			break;
//		}
//
//		open.add(currentNode);
//		currentNode.setHasBeenProcessed(true);
//
//		while (!open.isEmpty()) {
//			System.out.println("X After step: " + i);
//
//			currentNode = (Node) open.remove();
//			currentNode.setHasBeenVisited(true);
//			closed.add(currentNode);
//
//			System.out.println("i 'Closed' array contains:");
//			for (Node n : open) {
//				System.out.print(n.getId() + " (" + n.getHeuristicDistance() + "), ");
//			}
//
//			System.out.println();
//
//			if (currentNode.getEndingPointAttribute()) {
//				System.out.println("! Result found: " + currentNode.getId() + " STOPPED.");
//				results.addLast(currentNode.getId());
//				return;
//			} else {
//				for (Edge v : currentNode.getConnectedEdges()) {
//					if (v.getFirstNodeId() == currentNode.getId()) {
//						if (!_nodes.get(v.getOtherNodeId() - 1).getHasBeenProcessed()
//								&& !_nodes.get(v.getOtherNodeId() - 1).getHasBeenVisited()) {
//							_nodes.get(v.getOtherNodeId() - 1).setParentNode(currentNode);
//							// _nodes.get(v.getOtherEndId() -
//							// 1).setDistance(currentNode.getDistance() +
//							// v.getCost());
//							_nodes.get(v.getOtherNodeId() - 1).setHeuristicDistance(Heuristics.calculate(_destinations,
//									_nodes.get(v.getOtherNodeId() - 1), _heuristicId));
//							currentNode.getChildNodes().add(_nodes.get(v.getOtherNodeId() - 1));
//							_nodes.get(v.getOtherNodeId() - 1).setHasBeenProcessed(true);
//						}
//					} else {
//						if (!_nodes.get(v.getFirstNodeId() - 1).getHasBeenProcessed()
//								&& !_nodes.get(v.getFirstNodeId() - 1).getHasBeenVisited()) {
//							_nodes.get(v.getFirstNodeId() - 1).setParentNode(currentNode);
//							// _nodes.get(v.getFirstEndId() -
//							// 1).setDistance(currentNode.getDistance() +
//							// v.getCost());
//							_nodes.get(v.getFirstNodeId() - 1).setHeuristicDistance(Heuristics.calculate(_destinations,
//									_nodes.get(v.getFirstNodeId() - 1), _heuristicId));
//							currentNode.getChildNodes().add(_nodes.get(v.getFirstNodeId() - 1));
//							_nodes.get(v.getFirstNodeId() - 1).setHasBeenProcessed(true);
//						}
//					}
//				}
//
//				if (!currentNode.getChildNodes().isEmpty()) {
//					Collections.sort(currentNode.getChildNodes(), new ComparatorHeuristic());
//					for (Node n : currentNode.getChildNodes()) {
//						if (n.getHasBeenVisited() == false) {
//							open.add((Node) n);
//							System.out.println("Added to 'Open': " + n.getId() + " (" + n.getHeuristicDistance() + ")");
//						}
//					}
//				}
//
//				Collections.sort(open, new ComparatorHeuristic());
//
//				System.out.println("i 'Open' array contains: ");
//				for (Node n : open) {
//					System.out.print(n.getId() + " (" + n.getHeuristicDistance() + "), ");
//				}
//
//				System.out.println();
//			}
//
//			i++;
//		}
//	}

	/**
	 * Executes the concrete search algorithm.
	 *
	 * @param graph           The target graph on which the algorithm will work.
	 * @param searchKeyNodeId The identifier of the starting node ('search key').
	 * @param targetNodeIds   The identifier of the target nodes.
	 * @return A (possibly empty) collection of the search results.
	 */
	@Override
	public List<Integer> execute(Graph graph, Integer searchKeyNodeId, List<Integer> targetNodeIds) {
		return null;
	}
}
