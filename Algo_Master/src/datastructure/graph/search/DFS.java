package datastructure.graph.search;

import java.util.Stack;

/**
 * one example of DFS(Depth First Search)
 */
public class DFS {
    private final int maxVertices = 20;
    private Vertex vertexList[];
    private int adjMatrix[][];
    private int vertexCount;
    private Stack<Integer> stack;

    public DFS() {
        vertexList = new Vertex[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount = 0;
        for(int i=0; i<maxVertices; i++) {
            for(int j=0; j<maxVertices; i++) {
                adjMatrix[i][j] = 0;
            }
        }
        stack = new Stack<>();
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

    public void depthFirstSearch() {
        vertexList[0].visited = true;
        displayVertex(0);
        stack.push(0);
        while(stack.isEmpty() == false) {
            // 방문하지 않은 인접한 접점을 얻어와 스택 상단에 쌓는다
            int v = getAdjUnvisitedVertex(stack.peek());
            if(v == -1) {
                stack.pop();
            } else {
                vertexList[v].visited = true;
                displayVertex(v);
                stack.push(v);
            }
        }

    }

    private int getAdjUnvisitedVertex(int v) {
        for(int j=0; j<vertexCount; j++) {
            if (adjMatrix[v][j] == 1 && vertexList[j].visited == false) {
                return j;
            }
        }
        return -1;
    }

}

