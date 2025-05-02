import java.io.*;
import java.util.*;

public class Main {
	static int M;
	static int N;
	static int K;
	static int[] dx = new int[] {0, 0, -1, 1};
	static int[] dy = new int[] {1, -1, 0, 0};
	static boolean[][] visit;
	static int result = 0;
	static List<Integer> areas = new ArrayList<>();
	static int currentArea;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visit = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int startC = Integer.parseInt(st.nextToken());
			int startR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken()) - 1;
			int endR = Integer.parseInt(st.nextToken()) - 1;

			for (int c = startC; c <= endC; c++) {
				for (int r = startR; r <= endR; r++) {
					visit[r][c] = true;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					currentArea = 0;
					DFS(i, j);
					areas.add(currentArea);
				}
			}
		}

		Collections.sort(areas);
		System.out.println(areas.size());
		for (int area : areas) {
			System.out.print(area + " ");
		}
	}

	static void DFS(int m, int n) {
		visit[m][n] = true;
		currentArea++;

		for (int i = 0; i < 4; i++) {
			int nextM = m + dy[i];
			int nextN = n + dx[i];

			if (nextM >= 0 && nextN >= 0 && nextM < M && nextN < N) {
				if (!visit[nextM][nextN]) {
					DFS(nextM, nextN);
				}
			}
		}
	}
}