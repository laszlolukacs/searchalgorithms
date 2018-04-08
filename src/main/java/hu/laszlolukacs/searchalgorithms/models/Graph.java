package hu.laszlolukacs.searchalgorithms.models;

import java.util.List;

public interface Graph {
    boolean areNodesAdjacent(Node node1, Node node2); //: tests whether there is an edge from the vertex x to the vertex y;
    List<Node> getNeighborNodes(Node node); //: lists all vertices y such that there is an edge from the vertex x to the vertex y;
    void addNode(Node node); //: adds the vertex x, if it is not there;
    void removeNode(Node node); //: removes the vertex x, if it is there;
    void addEdge(Edge edge); //: adds the edge from the vertex x to the vertex y, if it is not there;
    void removeEdge(Edge edge); //: removes the edge from the vertex x to the vertex y, if it is there;
}
