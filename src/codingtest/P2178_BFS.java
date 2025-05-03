package src.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178_BFS {
    static int[] dx = {0, 1, 0, -1}; // → ↓ ← ↑ (x좌표 = 행)
    static int[] dy = {1, 0, -1, 0}; // → ↓ ← ↑ (y좌표 = 열)
    static boolean [][] visited;
    static int [][] A;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        BFS(0,0);
        System.out.println(A[N-1][M-1]);
    }
    private static void BFS(int start, int end) {
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[] {start,end}); // offer은 큐가 꽉 찼을 때 예외 대신 false를 반환한다.
        while (!queue.isEmpty()) {
            int [] now = queue.poll();
            System.out.println(now[0] + " " + now[1]);
            visited[now[0]][now[1]] = true;
            System.out.println(now[0] + " " + now[1]);
            for (int k = 0; k < 4; k++) { // 상하좌우 탐색
                int x = now[0] + dx[k]; // 오른쪽 왼쪽에 길이 있는지
                int y = now[1] + dy[k]; // 상 하에 길이 있는지
                if(x >= 0 && y >= 0 && x < N && y < M ){ // 배열을 넘어가면 안되고
                    System.out.println("now[0]: " + x + " now[1]: " + y + " dx: " + dx[k] + " dy: " + dy[k] + " visited: " + visited[x][y]);
                    if(A[x][y] != 0 && !visited[x][y]){ // 0이여서 갈 수 없거나
                        // 이제 갈 수 있는 곳이다.
                        System.out.println(x + " " + y + " visited: " + visited[x][y]);
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]]+1;
                        queue.add(new int[] {x,y});
                    }
                }
            }
        }
    }
}
