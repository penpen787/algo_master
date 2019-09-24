package datastructure.graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 위상정렬,
 * 시간복잡도(인접리스트) -> O(E + V)
 * https://bcp0109.tistory.com/21 참고, 예제는 해당 블로그에서 가져옴
 */
public class TopologicalSort {

    public void topologicalSort(int[] indegree, List<List<Integer>> graph) {

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int v;
        List<Integer> result = new LinkedList<>();

        while(q.isEmpty() == false) {
            v = q.poll();
            result.add(v+1);
            for (int w : graph.get(v)) {
                q.add(w);
                --indegree[v];
            }
        }

        System.out.println(result.stream().map(i -> i.toString()).collect(Collectors.joining(" -> ")));
    }


    @Test
    public void test() {
        int n = 7; // 정점 갯수
        int e = 9; // 간선 갯수
        int[] indegree = new int[n+1];
        List<List<Integer>> array = new ArrayList<List<Integer>>();

        for(int i=0; i<n+1; i++)
            array.add(new ArrayList<Integer>());

        // 간선 목록 v1 -> v2
        int[] v1 = {1, 1, 2, 4, 3, 3, 5, 2, 5};
        int[] v2 = {2, 3, 5, 6, 4, 7, 6, 4, 4};

        /**
         * 1. v1 -> v2 인접리스트 생성
         * 2. v2 를 가리키는 노드 갯수 indegree 증가
         */
        for(int i=0; i<e; i++) {
            int c1 = v1[i];
            int c2 = v2[i];

            array.get(c1).add(c2);
            indegree[c2]++;
        }

        topologicalSort(indegree, array);
    }
}
