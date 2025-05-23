package src.cs.graph;

import java.util.*;

public class GraphTraversal {

    // 그래프를 인접 리스트로 표현
    static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        // 그래프 초기화
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4, 5));
        graph.put(3, Arrays.asList(6));
        graph.put(4, Collections.emptyList());
        graph.put(5, Collections.emptyList());
        graph.put(6, Collections.emptyList());

        System.out.println("DFS:");
        Set<Integer> visitedDfs = new HashSet<>();
        dfs(1, visitedDfs);  // 시작 노드 1

        System.out.println("\nBFS:");
        bfs(1);  // 시작 노드 1
    }

    // DFS - 재귀 방식
    static void dfs(int node, Set<Integer> visited) {
        if (!visited.contains(node)) {
            System.out.print(node + " ");
            visited.add(node);

            for (int neighbor : graph.get(node)) {
                dfs(neighbor, visited);
            }
        }
    }

    // BFS - 큐 사용
    static void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited.contains(node)) {
                System.out.print(node + " ");
                visited.add(node);
                queue.addAll(graph.get(node));
            }
        }
    }
}
