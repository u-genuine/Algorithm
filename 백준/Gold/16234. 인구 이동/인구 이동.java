import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken()); // L 이상
		int R = Integer.parseInt(st.nextToken()); // R 이하

		int[][] nums = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int days = 0;

		while(true) {
			boolean[][] visited = new boolean[N][N];
			boolean moved = false;

			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(visited[i][j]) {
						continue;
					}

					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[]{i, j});
					List<int[]> union = new LinkedList<>();
					union.add(new int[]{i, j});

					visited[i][j] = true;

					while(!queue.isEmpty()) {
						int[] cur = queue.poll();

						for(int k = 0; k < 4; k++) {
							int nextR = cur[0] + dr[k];
							int nextC = cur[1] + dc[k];

							if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < N) {
								if(!visited[nextR][nextC]) {
									int sub = Math.abs(nums[cur[0]][cur[1]] - nums[nextR][nextC]);
									if(sub >= L && sub <= R) {
										visited[nextR][nextC] = true;
										queue.add(new int[]{nextR, nextC});
										union.add(new int[]{nextR, nextC});
									}
								}
							}
						}
					}

					int unionSize = union.size();

					if(unionSize > 1) {
						moved = true;

						int sum = 0;
						for(int[] one : union) {
							sum += nums[one[0]][one[1]];
						}

						for(int[] one : union) {
							nums[one[0]][one[1]] = sum/unionSize;
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