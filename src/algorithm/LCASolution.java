package src.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LCASolution {
    static final int MAX = 17; // 2^17 = 131072 > 100000
    static int N, M;
    static int[] depth;
    static int[][] parent;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        tree = new ArrayList[N + 1];
        depth = new int[N + 1];
        parent = new int[N + 1][MAX];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 트리 간선 정보 입력
        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        // DFS로 부모와 깊이 계산
        dfs(1, 0);

        // 이진 점프 테이블 계산
        for (int i = 1; i < MAX; i++) {
            for (int j = 1; j <= N; j++) {
                if (parent[j][i - 1] != 0) { // j의 2^(i-1)번째 조상 != 0
                    System.out.println("parent["+j+"]["+(i)+"] : " + parent[parent[j][i - 1]][i - 1]);
                    parent[j][i] = parent[parent[j][i - 1]][i - 1];
                }
            }
        }

        M = sc.nextInt();
        // 쿼리 처리
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(lca(a, b));
        }
    }

    // DFS로 부모와 깊이 계산
    static void dfs(int node, int par) {
        parent[node][0] = par;
        for (int next : tree[node]) {
            if (next != par) {
                depth[next] = depth[node] + 1;
                dfs(next, node);
            }
        }
    }

    // 두 노드의 최소 공통 조상 찾기
    static int lca(int a, int b) {
        // 깊이 맞추기
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // 깊이 차이 맞추기
        for (int i = MAX - 1; i >= 0; i--) {
            if (depth[a] - depth[b] >= (1 << i)) {
                a = parent[a][i];
            }
        }

        // a와 b가 같으면 최소 공통 조상
        if (a == b) return a;

        // 2^i만큼 위로 올라가면서 부모 찾기
        for (int i = MAX - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        // 최소 공통 조상
        return parent[a][0];
    }
}