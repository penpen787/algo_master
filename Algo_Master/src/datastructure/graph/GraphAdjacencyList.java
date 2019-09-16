package datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Directed Graph
 */
public class GraphAdjacencyList {

    private List<List<Integer>> vertices;
    private int vertexCount = 0;

    public GraphAdjacencyList(int vertexCount) {
        this.vertexCount = vertexCount;
        vertices = new ArrayList<>(vertexCount);
        for(int i=0; i<vertexCount; i++) {
            vertices.add(new LinkedList<Integer>());
        }
    }

    public void addEdge(int source, int dest) {
        vertices.get(source).add(dest);
        // if undirected graph
        // vertices.get(dest).add(source);
    }
}



