/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.implementations;

import java.util.Collections;
import java.util.List;

import hu.laszlolukacs.searchalgorithms.models.Graph;
import hu.laszlolukacs.searchalgorithms.models.Node;
import hu.laszlolukacs.searchalgorithms.models.Edge;
import hu.laszlolukacs.searchalgorithms.models.SymmetricDirectedGraph;
import hu.laszlolukacs.searchalgorithms.models.comparators.ComparatorByDistance;

/**
 * Contains the implementation of the Uniform cost search algorithm.
 */
public class UniformCostSearch extends SearchBase implements SearchAlgorithm {

	/**
	 * Initializes a new instance of the `UniformCostSearch` class.
	 */
	public UniformCostSearch() {
		super();
	}

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

//	/**
//	 * Executes the Uniform cost search algorithm.
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
//		System.out.println("*****\nExecuting Uniform cost search...\n*****");
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
//			for (Node n : closed) {
//				System.out.print(n.getId() + " (" + n.getDistance() + "), ");
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
//							_nodes.get(v.getOtherNodeId() - 1).setDistance(currentNode.getDistance() + v.getCost());
//							currentNode.getChildNodes().add(_nodes.get(v.getOtherNodeId() - 1));
//							_nodes.get(v.getOtherNodeId() - 1).setHasBeenProcessed(true);
//						}
//					} else {
//						if (!_nodes.get(v.getFirstNodeId() - 1).getHasBeenProcessed()
//								&& !_nodes.get(v.getFirstNodeId() - 1).getHasBeenVisited()) {
//							_nodes.get(v.getFirstNodeId() - 1).setParentNode(currentNode);
//							_nodes.get(v.getFirstNodeId() - 1).setDistance(currentNode.getDistance() + v.getCost());
//							currentNode.getChildNodes().add(_nodes.get(v.getFirstNodeId() - 1));
//							_nodes.get(v.getFirstNodeId() - 1).setHasBeenProcessed(true);
//						}
//					}
//				}
//
//				if (!currentNode.getChildNodes().isEmpty()) {
//					Collections.sort(currentNode.getChildNodes(), new ComparatorByDistance());
//					for (Node n : currentNode.getChildNodes()) {
//						if (n.getHasBeenVisited() == false) {
//							open.add((Node) n);
//							System.out.println("Added to 'Open': " + n.getId() + " (" + n.getDistance() + ")");
//						}
//					}
//				}
//
//				Collections.sort(open, new ComparatorByDistance());
//
//				System.out.println("i 'Open' array contains: ");
//				for (Node n : open) {
//					System.out.print(n.getId() + " (" + n.getDistance() + "), ");
//				}
//
//				System.out.println();
//			}
//
//			i++;
//		}
//	}
}
