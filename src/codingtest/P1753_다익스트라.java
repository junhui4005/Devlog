package src.codingtest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1753_다익스트라 {

    static List<Node>[] graph;
    static int [] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        for(int i = 1; i <= V; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v,w));
        }

        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[K] = 0;

        total(K);

        for(int i = 1; i <= V; i++){
            if(dist[i] == INF){
                System.out.println("INF");
            }else System.out.println(dist[i]);
        }
    }

    static class Node implements Comparable<Node>{
        int index;
        int distance;

        Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    static void total(int K){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.index;
            int cost = node.distance;
            if(dist[now] < cost){
                continue;
            }
            for(Node n : graph[now]){
                int totalCost = dist[now] + n.distance;
                if(totalCost < dist[n.index]){
                    dist[n.index] = totalCost;
                    pq.offer(new Node(n.index,totalCost));
                }
            }
        }
    }
}

