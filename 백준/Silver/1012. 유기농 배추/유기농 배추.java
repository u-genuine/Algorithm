/*
1. 방문할 노드 visited[][] == 0인지 확인 후 방문
2. 방문한 노드 visited[][] = 1
3. 상, 하, 좌, 우 반복
3-1. 방문할 노드가 방문 가능한 노드인지 확인 (범위, 방문여부, 배추여부)
3-1-1 방문할 수 있으면 1~3 반복
*/
import java.util.*;

class Main {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int[][] farm;
	static int[][] visited;

	static int M, N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		for(int i = 0; i < T; i++) {
			M = sc.nextInt(); // 가로(열)
			N = sc.nextInt(); // 세로(행)
			K = sc.nextInt(); // 배추 개수

			farm = new int[N][M];
			visited = new int[N][M];

			// 배추 채우기
			for(int j = 0; j < K; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				farm[y][x] = 1;
			}

			int count = 0;
			for(int j = 0; j < N; j++) { // 행
				for(int k = 0; k < M; k++) { // 열
					if(farm[j][k] == 1 && visited[j][k] == 0){
						count++;
						DFS(k, j);
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	static void DFS(int x, int y){ // 열, 행
		visited[y][x] = 1;

		for(int i = 0; i < 4; i++){
			int next_x = x + dx[i];
			int next_y = y + dy[i];

			if((next_x < M && next_x >= 0 && next_y < N && next_y >= 0) // 범위 체크
				&& (farm[next_y][next_x] == 1) // 배추가 있는 위치인지 체크
				&& (visited[next_y][next_x] == 0)) {// 아직 방문하지 않았는지 체크
				DFS(next_x, next_y);
			}
		}
	}
}
