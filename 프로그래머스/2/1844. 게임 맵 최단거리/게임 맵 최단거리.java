import java.util.*;

class Solution {
    // 상하좌우 좌표
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
        
    public int solution(int[][] maps) {
        int answer = 0;
    
        int[][] visited = new int[maps.length][maps[0].length];
        
        int result = bfs(maps, visited, maps.length-1, maps[0].length-1);
        return (result == 0) ? -1 : result;
        
        // answer = visited[maps.length-1][maps[0].length-1];
        
        // if(answer == 0)
            // answer = -1;
        
        // return answer;
    }
    
    public int bfs(int[][] maps, int[][] visited, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0}); // 큐에 시작점 (0, 0) 추가
        visited[0][0] = 1; // 시작점 방문 거리 1
        
        while(!queue.isEmpty()){ // 큐가 빌 때까지 반복
            int[] current = queue.poll(); // 현재 위치 꺼내기
            
            // 현재 좌표
            int cX = current[0];
            int cY = current[1];
            
            for(int i = 0; i < 4; i++) { // 상하좌우 이동
                // 다음 좌표
                int nX = cX + dx[i];
                int nY = cY + dy[i];
                
                // 범위를 벗어나면 건너뛰기
                if(nX < 0 || nX > row || nY < 0 || nY > col) {
                    continue;
                }
                
                // 방문하지 않았고, 갈 수 있는 길(1)인지 확인
                if(visited[nX][nY] == 0 && maps[nX][nY] == 1) {
                    visited[nX][nY] = visited[cX][cY] + 1; // 거리 업데이트
                    queue.add(new int[] {nX, nY}); // 큐에 추가해서 다음 탐색
                }
            }
        }
        
        return visited[row][col];
        
    }
}