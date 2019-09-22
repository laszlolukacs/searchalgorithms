/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.implementations;

import hu.laszlolukacs.searchalgorithms.models.Graph;
import hu.laszlolukacs.searchalgorithms.models.Node;

import java.util.*;

/**
 * Abstract base class for concrete search algorithm implementations. Contains
 * the common necessary data structures.
 */
public abstract class SearchBase implements SearchAlgorithm {

    /**
     * The nodes queued to be processed by the algorithm.
     */
    protected Deque<Node> open;

    /**
     * The nodes which have been already processed by the algorithm.
     */
    protected Queue<Node> closed;

    /**
     * The results of the algorithm.
     */
    protected List<Integer> results;

    /**
     * Initializes a new instance of the `SearchBase` abstract class.
     */
    public SearchBase() {
        this.open = new LinkedList<Node>();
        this.closed = new LinkedList<Node>();
        this.results = new LinkedList<Integer>();
    }

    /**
     * Executes the concrete search algorithm.
     *
     * @param graph           The target graph on which the algorithm will work.
     * @param searchKeyNodeId The identifier of the starting node ('search key').
     * @param targetNodeIds   The identifier of the target nodes.
     * @return A (possibly empty) collection of the search results.
     */
    public abstract List<Integer> execute(final Graph graph, final Integer searchKeyNodeId, final List<Integer> targetNodeIds);

    /**
     * Backtracks the specified result node to the starting node.
     *
     * @param resultNode The target node which was found first.
     * @return A collection of node identifiers representing a route from the starting node to the (first) result node in the graph.
     */
    protected List<Integer> backtrackResultNode(final Node resultNode) {
        List<Node> resultChain = this.buildRouteToStartingNode(resultNode);
        // inverse iterates the route from the result to the starting node
        return this.iterateRouteBackwards(resultChain);
    }

    /**
     * Builds a route from the specified result node to the starting node.
     *
     * @param resultNode The result node which was found first.
     * @return A collection (route) of nodes, which is leading from the result node to the starting node.
     */
    private List<Node> buildRouteToStartingNode(final Node resultNode) {
        ArrayList<Node> resultChain = new ArrayList<Node>();
        Node node = resultNode;
        while (true) {
            resultChain.add(node);
            if (node.getParentNode() == null) {
                break;
            } else {
                node = node.getParentNode();
            }
        }

        return resultChain;
    }

    /**
     * Iterates the specified route of nodes backwards and extracts their identifiers.
     *
     * @param route A collection (route) of nodes.
     * @return A collection of identifiers of the inverted route.
     */
    private List<Integer> iterateRouteBackwards(final List<Node> route) {
        List<Integer> invertedRoute = new ArrayList<Integer>();
        // inverse iterates the route from the result to the starting node
        ListIterator iterator = route.listIterator(route.size());
        while (iterator.hasPrevious()) {
            Node currentNode = (Node) iterator.previous();
            invertedRoute.add(currentNode.getId());
        }

        return invertedRoute;
    }
}
