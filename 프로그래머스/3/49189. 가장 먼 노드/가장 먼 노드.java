import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 그래프 인접 리스트 생성
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 그래프 연결
        for(int[] e : edge){
            int v1 = e[0];
            int v2 = e[1];
            graph.get(v1).add(e[1]);
            graph.get(v2).add(e[0]);
        }
        
        // 1번 노드부터의 거리 배열. 최대 거리로 초기화
        int[] distance = new int[n+1];
        Arrays.fill(distance, n+1);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        distance[1] = 0;
        
        // BFS
        while(!queue.isEmpty()) { // 큐가 빌 때까지 반복
            int node = queue.poll(); // 현재 방문할 노드 꺼내기
            for(int next : graph.get(node)) { // 현재 노드와 연결된 모든 노드 확인
              if(distance[next] > distance[node] + 1) { // 더 짧은 경로 발견
                  distance[next] = distance[node] + 1; // 최단 거리 업데이트
                  queue.offer(next);
              }  
            }
        }
        
        // 거리 배열 정렬
        Arrays.sort(distance);
    
        int max = distance[n-1];
        int count = 0;
        
        for(int i = n-1; i >= 0; i--) {
            if(distance[i] != max)
                break;
            count++;
        }
        
        return count;
    }
}