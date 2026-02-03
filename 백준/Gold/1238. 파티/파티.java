import java.util.*;
import java.io.*;

class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // ~ 1000
        int M = Integer.parseInt(st.nextToken()); // ~ 10000
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] adj = new ArrayList[N+1];
        for(int i = 1; i < N+1; i++) {
            adj[i] = new ArrayList<Node>();
        }
        
        // 단방향 도로 정보
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            adj[from].add(new Node(to, time));
        }

        int answer = 0;
        
        // X에서 각 마을로 돌아가는 최단시간
        int[] fromX = dijkstra(adj, X);
        
        // 각 마을에서 X로 가는 최단시간
        for (int i = 1; i < N+1; i++) {
            int[] fromI = dijkstra(adj, i);
            answer = Math.max(answer, fromI[X] + fromX[i]);
        }

        System.out.println(answer);

    }

    // start에서 각 도시로의 최단 시간
    static int[] dijkstra(ArrayList<Node>[] adj, int start) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.time - n2.time);
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll(); // pq에서 가장 가까운 노드 꺼냄

            // 이미 더 짧은 시간으로 처리했으면 스킵
            if(cur.time > dist[cur.city]) continue; 

            // 시작노드부터 cur까지 최소 시간 발견한 경우
            // 현재 도시에서 갈 수 있는 인접 도시들 확인
            for (Node next : adj[cur.city]) {
                // 현재 도시를 거쳐가는 경로의 총 시간
                int newDist = dist[cur.city] + next.time; 

                // 더 빠른 경로 발견 시 업데이트
                if(newDist < dist[next.city]) {
                    dist[next.city] = newDist; 
                    pq.add(new Node(next.city, newDist));
                }
            }
        }

        return dist;
    }
}

// 누적 거리 정보
class Node {
    int city;
    int time;
    Node(int city, int time) {
        this.city = city;
        this.time = time;
    }
}