package src.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P11657_벨만포드 {
    static long INF = Long.MAX_VALUE;
    static int N, M;
    static List<Edge> edges = new ArrayList<>();
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, cost));
        }

        dist = new long[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        if(check()){
            System.out.println("-1");
        }else{
            for(int i =2;i<=N;i++){
                System.out.println(dist[i] == INF ? "-1" : dist[i]);
            }
        }
    }

    static boolean check(){
        for(int i = 1;i<N;i++){
            for(Edge e : edges){
                if(dist[e.from] != INF && dist[e.from] > dist[e.to] + e.cost){
                    dist[e.to] = dist[e.to] + e.cost;
                }
            }
        }
        for(Edge e : edges){
            if(dist[e.from] != INF && dist[e.to] > dist[e.from] + e.cost){
                return true;
            }
        }

        return false;
    }

    private static class Edge{
        int from, to, cost;
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
