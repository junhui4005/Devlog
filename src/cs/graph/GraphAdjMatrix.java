package src.cs.graph;

// 인접 행렬방식
public class GraphAdjMatrix {
    public static void main(String[] args) {
        int vertices = 5;
        int[][] graph = new int[vertices][vertices];

        // 간선 추가 (무방향이므로 양쪽 다 1)
        graph[0][1] = graph[1][0] = 1;
        graph[0][4] = graph[4][0] = 1;
        graph[1][2] = graph[2][1] = 1;
        graph[2][3] = graph[3][2] = 1;
        graph[3][4] = graph[4][3] = 1;

        // 출력
        for (int i = 0; i < vertices; i++) {
            System.out.print("Node " + i + ": ");
            for (int j = 0; j < vertices; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
