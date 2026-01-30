import java.util.*;
import java.io.*;

class Main {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N+1];
        StringTokenizer st;
        for(int n = 1; n < N+1; n++) {
            st = new StringTokenizer(br.readLine());
            adj[n] = new ArrayList<Integer>();
            for(int i = 1; i < N+1; i++) {
                int conn = Integer.parseInt(st.nextToken());
                if(conn == 1) adj[n].add(i);
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] plan = new int[M];
        for(int m = 0; m < M; m++) {
            plan[m] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N+1];

        if(M > 0) {
            dfs(plan[0]);
        }

        for(int i = 0; i < M; i++) {
            if(!visited[plan[i]]) {
                System.out.println("NO");
                return;
            }
        }
        
        System.out.println("YES");
    }

    static void dfs(int cur) {
        visited[cur] = true;

        for(int next : adj[cur]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}