import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        int answer = BFS(map);
        System.out.println(answer);
        
    }

    static int BFS(int[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][2];

        queue.add(new int[]{0, 0, 1 ,0}); // x, y, 거리, 벽부순횟수
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            int broke = cur[3];

            if(x == N-1 && y == M-1) return dist;

            for(int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
    
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(visited[nextX][nextY][broke]) continue;
                
                if(map[nextX][nextY] == 1) {
                    if(broke == 1) continue;
                    visited[nextX][nextY][1] = true;
                    queue.add(new int[]{nextX, nextY, dist + 1, 1}); // 벽 부수고 진입
                } else {
                    visited[nextX][nextY][broke] = true;
                    queue.add(new int[]{nextX, nextY, dist + 1, broke});
                }
    
            }
        }

        return -1;
    }
}