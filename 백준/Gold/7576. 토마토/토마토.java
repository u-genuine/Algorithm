import java.util.*;
import java.io.*;
class Main {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};

	static int[][] tomatoBox;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken()); // 열
		int N = Integer.parseInt(st.nextToken()); // 행

		tomatoBox = new int[N][M];
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomatoBox[i][j] = Integer.parseInt(st.nextToken());

				if (tomatoBox[i][j] == 1) {
					queue.add(new int[] {i, j});
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];

			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];

				if (nextX >= 0 && nextX < N &&
					nextY >= 0 && nextY < M) {
					if (tomatoBox[nextX][nextY] == 0) {
						tomatoBox[nextX][nextY] = tomatoBox[x][y] + 1;
						queue.add(new int[] {nextX, nextY});
					}
				}

			}
		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomatoBox[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				result = Math.max(tomatoBox[i][j], result);
			}
		}

		if (result == 1) {
			System.out.println(0);
		} else {
			System.out.println(result - 1);
		}
	}
}