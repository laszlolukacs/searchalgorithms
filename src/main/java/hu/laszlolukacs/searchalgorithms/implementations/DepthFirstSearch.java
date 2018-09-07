/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.implementations;

import hu.laszlolukacs.searchalgorithms.models.Graph;
import hu.laszlolukacs.searchalgorithms.models.Node;
import hu.laszlolukacs.searchalgorithms.models.SymmetricDirectedGraph;
import hu.laszlolukacs.searchalgorithms.models.comparators.ComparatorById;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Contains the implementation of the Depth-first search (DFS) algorithm.
 */
public class DepthFirstSearch extends SearchBase implements SearchAlgorithm {

    private List<Integer> targetNodeIds;

    /**
     * Initializes a new instance of the `DepthFirstSearch` class.
     */
    public DepthFirstSearch() {
        super();
    }

    /**
     * Executes the Depth-first search algorithm.
     *
     * @param graph           The target graph on which the algorithm will work.
     * @param searchKeyNodeId The identifier of the starting node.
     * @param targetNodeIds   The identifier of the target nodes.
     * @return A (possibly empty) collection of the search results.
     */
    public List<Integer> execute(final Graph graph, final Integer searchKeyNodeId, final List<Integer> targetNodeIds) {
        this.targetNodeIds = targetNodeIds;
        Map<Integer, Node> nodes = ((SymmetricDirectedGraph) graph).getNodes();
        Node currentNode = nodes.get(searchKeyNodeId);
        open.add(currentNode);
        while (!open.isEmpty()) {
            currentNode = open.remove();
            closed.add(currentNode);

            boolean targetFound = this.checkIfNodeIsTarget(currentNode);
            if (targetFound) {
                // if the first goal has been reached, the algorithm stops
                results.add(currentNode.getId());
                return super.backtrackResultNode(currentNode);
            } else {
                List<Node> childNodes = this.getChildNodesForNode(currentNode);
                if (!childNodes.isEmpty()) {
                    Collections.sort(childNodes, new ComparatorById());
                    Collections.reverse(childNodes);
                    for (Node node : childNodes) {
                        open.addFirst(node);
                    }
                }
            }
        }

        return super.results;
    }

    /**
     * Checks if the specified node is in the target (goal) nodes collection.
     *
     * @param node The node to be checked.
     * @return True, if the specified node is in the target nodes collection, otherwise false.
     */
    private boolean checkIfNodeIsTarget(Node node) {
        for (Integer targetNodeId : this.targetNodeIds) {
            if (targetNodeId == node.getId()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Gets the child nodes (all neighboring nodes which haven't been visited yet) belonging to the specified node.
     *
     * @param node The origin node.
     * @return A (possibly empty) collection of child nodes belonging to the specified node.
     */
    private List<Node> getChildNodesForNode(Node node) {
        List<Node> childNodes = new ArrayList<Node>();
        for (Node neighborNode : node.getNeighborNodes()) {
            // if the algorithm's closed queue contains the node, exclude it from the child nodes collection
            if (!super.closed.contains(neighborNode)) {
                neighborNode.setParentNode(node);
                childNodes.add(neighborNode);
            }
        }

        return childNodes;
    }
}
