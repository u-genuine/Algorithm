class Solution {
    static int count = 0;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        DFS(0, k, dungeons);
        return count;
    }
    
    void DFS(int depth, int remain, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i] ||  dungeons[i][0] > remain) { // 방문 했거나, 최소 필요 피로도 만족 못하면 패스
                continue;
            }
            visited[i] = true;
            DFS(depth+1, remain - dungeons[i][1], dungeons);
            visited[i] = false;
        }
        count = Math.max(count, depth);
    }
}