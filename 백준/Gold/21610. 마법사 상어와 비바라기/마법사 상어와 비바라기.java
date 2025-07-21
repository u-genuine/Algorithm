import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int water[][] = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				water[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] clouds = new boolean[N+1][N+1];
		clouds[N-1][1] = true;
		clouds[N-1][2] = true;
		clouds[N][1] = true;
		clouds[N][2] = true;

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());

			boolean[][] movedClouds = new boolean[N+1][N+1];
			for(int r = 1; r <= N; r++) {
				for(int c = 1; c <= N; c++) {
					if(clouds[r][c]) {
						int movedR = intoMap(r + dr[dir] * length);
						int movedC = intoMap(c + dc[dir] * length);

						movedClouds[movedR][movedC] = true;
					}
				}
			}
			clouds = movedClouds; // 구름 모두 이동

			// 비 내림, 바구니 물 증가
			List<int[]> rainy = new ArrayList<>();
			for(int r = 1; r <= N; r++) {
				for(int c = 1; c <= N; c++) {
					if(clouds[r][c]) {
						water[r][c]++;
						rainy.add(new int[]{r, c});
					}
				}
			}

			// 물 복사
			for(int[] one : rainy) {
				int r = one[0];
				int c = one[1];

				int[] ddr = new int[]{-1, -1, 1, 1};
				int[] ddc = new int[]{-1, 1, 1, -1};

				for(int j = 0; j < 4; j++) {
					int nextR = r + ddr[j];
					int nextC = c + ddc[j];

					if(nextR >= 1 && nextR <= N && nextC >= 1 && nextC <= N) {
						if(water[nextR][nextC] > 0)
							water[r][c]++;
					}
				}
			}

			boolean[][] newClouds = new boolean[N+1][N+1];
			for(int r = 1; r <= N; r++) {
				for(int c = 1; c <= N; c++) {
					if(water[r][c] >= 2 && !clouds[r][c]) {
						water[r][c] -= 2;
						newClouds[r][c] = true;
					}
				}
			}

			clouds = newClouds;
		}

		int result = 0;
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= N; c++) {
				result += water[r][c];
			}
		}

		System.out.println(result);
	}

	static int intoMap (int moved) {
		while(moved < 1) {
			moved += N;
		}
		while(moved > N) {
			moved -= N;
		}

		return moved;
	}
}