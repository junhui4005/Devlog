package src.cs.graph;

import java.util.*;

// 인접 리스트 방식
public class GraphAdjList {
    public static void main(String[] args) {
        int vertices = 5;
        List<List<Integer>> graph = new ArrayList<>();

        // 그래프 초기화
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 추가 (무방향)
        graph.get(0).add(1);
        graph.get(0).add(4);

        graph.get(1).add(0);
        graph.get(1).add(2);

        graph.get(2).add(1);
        graph.get(2).add(3);

        graph.get(3).add(2);
        graph.get(3).add(4);

        graph.get(4).add(0);
        graph.get(4).add(3);

        // 출력
        for (int i = 0; i < vertices; i++) {
            System.out.println("Node " + i + ": " + graph.get(i));
        }
    }
}
