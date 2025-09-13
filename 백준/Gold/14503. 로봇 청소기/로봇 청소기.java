import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] dr = new int[] {-1, 0, 1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};
	static int[][] map;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		int curR = Integer.parseInt(st.nextToken());
		int curC = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		clean(curR, curC, dir);
		System.out.print(result);
	}

	static void clean(int curR, int curC, int dir) {
		if (map[curR][curC] == 0) {
			map[curR][curC] = 2; // 청소한 칸은 2
			result++;
		}
		
		int tempDir = dir;
		for(int i = 0; i < 4; i++) {
			tempDir = (tempDir + 3) % 4;
			int nextR = curR + dr[tempDir];
			int nextC = curC + dc[tempDir];
			if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) { // 범위 체크
				if(map[nextR][nextC] == 0) { // 청소되지 않았을 경우
					clean(nextR, nextC, tempDir);
					return;
				}
			}
		}
		
		int nextR = curR + dr[(dir + 2) % 4];
		int nextC = curC + dc[(dir + 2) % 4];
		if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) { // 범위 체크
			if(map[nextR][nextC] != 1) { // 후진 가능한 경우
				clean(nextR, nextC, dir); // 현재 방향 그대로 후진
			}
		}
	}
}