import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] visit = new boolean[N+1]; // 0 ~ N번 노드 방문 여부 (0은 사용X)
        int[] parent = new int[N+1]; // 0 ~ N번 노드의 부모 노드 (0, 1은 사용 X)
        ArrayList<Integer>[] adj = new ArrayList[N+1]; // 0 ~ N번 노드의 인접 노드 저장 (0은 사용X)
        
        for(int i = 0; i < N + 1; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            adj[node1].add(node2);
            adj[node2].add(node1);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int next : adj[now]) {
                if(!visit[next]){
                    visit[next] = true;
                    queue.add(next);
                    parent[next] = now;
                }
            }
        }
        
        for(int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }
}