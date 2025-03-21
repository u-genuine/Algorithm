class Solution {
    static int[][] graph; // 인접 행렬
    static boolean[] visited;
    static int min; // 차이의 최솟값
    static int N; // 총 송전탑 개수
    
    public int solution(int n, int[][] wires) {
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];
        min = n;
        N = n;
        
        // 인접 리스트 초기화
        for(int[] wire : wires) {
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }
        
        dfs(1); // 1번 송전탑부터 시작
        return min;
    }
    
    int dfs(int num) {
        visited[num] = true;
        int connectCount = 1; // 현재 송전탑 포함해서 연결된 송전탑 수
        for(int i = 1; i <= N; i++){
            if(graph[num][i] == 1 && !visited[i]){
                visited[i] = true;
                connectCount += dfs(i); 
            }
        }
        min = Math.min(min, Math.abs(connectCount - (N - connectCount)));
        return connectCount;
    }
}