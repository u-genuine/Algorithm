import java.io.*;
import java.util.*;

public class Main {
	static int N; // 세로 크기 (행)
	static int M; // 가로 크기 (열)
	static int[][] map;
	static boolean[][] visited;
	static int maxArea = 0;

	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					count++;

					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[] {i, j});
					visited[i][j] = true;
					int area = 0;

					while (!queue.isEmpty()) {
						int[] current = queue.poll();
						area++;

						for (int k = 0; k < 4; k++) {
							int nextR = current[0] + dr[k];
							int nextC = current[1] + dc[k];

							if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) {
								if (!visited[nextR][nextC] && map[nextR][nextC] == 1) {
									visited[nextR][nextC] = true;
									queue.add(new int[] {nextR, nextC});
								}
							}
						}
					}

					maxArea = Math.max(maxArea, area);
				}
			}
		}
		System.out.println(count);
		System.out.println(maxArea);

	}
}