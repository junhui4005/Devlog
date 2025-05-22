package src.codingtest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1197_최소신장트리 {
    static int N;
    static int M;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue(N);
        parent = new int[N+1];

        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(from, to, cost));
        }

        int total = 0;
        int count = 0;

        while(!pq.isEmpty() && count < N-1){
            Edge e = pq.poll();
            if(union(e.from, e.to)){
                total += e.cost;
                count++;
            }
        }
        System.out.println(total);
    }

    static boolean union(int a, int b){
        a = parent[a];
        b = parent[b];
        if(a == b) return false;
        parent[b] = a;
        return true;
    }

    static int find(int a) {
        if(a != parent[a]){
            parent[a] = parent[parent[a]];
        }
        return parent[a];
    }

    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }


        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}

