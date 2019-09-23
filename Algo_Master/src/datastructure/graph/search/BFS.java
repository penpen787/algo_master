package datastructure.graph.search;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * one example of BFS(Breadth-First Search)
 */
public class BFS {
    private final int maxVertices = 20;
    private Vertex vertexList[];
    private int adjMatrix[][];
    private int vertexCount;
    private Queue<Integer> queue;

    public BFS() {
        vertexList = new Vertex[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount = 0;
        for(int i=0; i<maxVertices; i++) {
            for(int j=0; j<maxVertices; j++) {
                adjMatrix[i][j] = 0;
            }
        }
        queue = new PriorityQueue<>();
    }

    public void addVertex(char lab) {
        vertexList[vertexCount++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }

    public void breadthFirstSearch() {
        vertexList[0].visited = true;
        displayVertex(0);
        queue.add(0);

        int v2;
        while(queue.isEmpty() == false) {
            int v1 = queue.remove();
            while((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].visited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }
    }

    private int getAdjUnvisitedVertex(int v) {
        for(int i=0; i<vertexCount; i++) {
            if (adjMatrix[v][i] == 1 && vertexList[i].visited == false) {
                return i;
            }
        }
        return -1;
    }
}
