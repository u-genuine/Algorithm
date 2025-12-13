import java.util.*;

class Solution {    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<Node>[] graph = new ArrayList[n + 1]; // 1 ~ n번 지점의 인접 지점 리스트 
        
        // 그래프 초기화
        for(int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 인접 지점 정보 추가
        for(int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            
            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }
        
        // S, A, B 지점에서 다익스트라
        int[] distFromS = dijkstra(s, graph, n);
        int[] distFromA = dijkstra(a, graph, n);
        int[] distFromB = dijkstra(b, graph, n);
        
        int answer = Integer.MAX_VALUE;
        for(int k = 1; k <= n; k++) {
            int cost = distFromS[k] + distFromA[k] + distFromB[k];
            answer = Math.min(answer, cost);
        }
        
        return answer;
    }
    
    
    // 시작 지점부터 모든 지점까지의 최단 비용 계산
    int[] dijkstra(int start, List<Node>[] graph, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int curVertex = current.v;
            int curCost = current.cost;
            
            if(curCost > dist[curVertex]) continue;
            
            for(Node next : graph[curVertex]) {
                int newCost = curCost + next.cost;
                
                if(newCost < dist[next.v]) {
                    dist[next.v] = newCost;
                    pq.offer(new Node(next.v, newCost));
                }
            }
        }
        
        return dist;
        
    }
}

class Node implements Comparable<Node> {
    int v;
    int cost;

    Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node n) {
        return this.cost - n.cost;
    }
}
