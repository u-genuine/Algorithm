import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N, M;
	static int result = 0;

	// 북, 동, 남, 서
	static int[] dr = new int[]{-1, 0, 1, 0};
	static int[] dc = new int[]{0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 로봇 청소기
		st = new StringTokenizer(br.readLine());
		int nowR = Integer.parseInt(st.nextToken());
		int nowC = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());

		// 방 정보
		visited = new boolean[N][M];
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		DFS(nowR, nowC, dir);
		System.out.println(result);
	}

	static void DFS(int nowR, int nowC, int dir) {
		if(!visited[nowR][nowC]) {
			// 현재 칸 청소
			visited[nowR][nowC] = true;
			result++;
		}



		// 주변 4칸에 청소 안한 칸 있는지 탐색
		int tempDir = dir;
		for(int i = 0; i < 4; i++) {
			// 반시계 방향 회전
			tempDir = (tempDir + 3) % 4;
			int nextR = nowR + dr[tempDir];
			int nextC = nowC + dc[tempDir];

			if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) {
				if(!visited[nextR][nextC] && map[nextR][nextC] == 0) {
					DFS(nextR, nextC, tempDir);
					return;
				}
			}
		}

		// 주변 모두 청소된 경우
		// 현재 방향에서 후진
		int nextR = nowR - dr[dir];
		int nextC = nowC - dc[dir];

		if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) {
			if(map[nextR][nextC] == 0) {
				DFS(nextR, nextC, dir);
			}
		}

	}
}
