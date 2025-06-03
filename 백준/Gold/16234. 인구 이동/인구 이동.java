import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = new int[]{-1, 1, 0, 0};
	static int[] dc = new int[]{0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		int days = 0;

		while(true) {
			boolean[][] visit = new boolean[N][N];
			boolean moved = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j])
						continue;

					Queue<int[]> queue = new LinkedList<>();
					List<int[]> union = new ArrayList<>();
					queue.add(new int[] {i, j});
					union.add(new int[] {i, j});

					visit[i][j] = true;

					while (!queue.isEmpty()) {
						int[] cur = queue.poll();

						for (int k = 0; k < 4; k++) {
							int nextR = cur[0] + dr[k];
							int nextC = cur[1] + dc[k];

							if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N) {
								if (!visit[nextR][nextC]) {

									int sub = Math.abs(map[cur[0]][cur[1]] - map[nextR][nextC]);
									if (sub >= L && sub <= R) {
                                        visit[nextR][nextC] = true;
										queue.add(new int[] {nextR, nextC});
										union.add(new int[] {nextR, nextC});
									}
								}
							}
						}
					}

					int unionSize = union.size();

					if(unionSize > 1) {
						moved = true;

						int sum = 0;
						for (int[] one : union) {
							sum += map[one[0]][one[1]];
						}

						for (int[] one : union) {
							map[one[0]][one[1]] = sum / unionSize;
						}
					}
				}
			}

			if(!moved) {
				break;
			}

			days++;
		}

		System.out.println(days);
	}
}