import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dx[] = {0, 1, 0, -1}; // 하, 우, 상, 좌
	static int dy[] = {1, 0, -1, 0};
	static int[][] A;
	static boolean[][] visited;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// N M은 공백으로 구분 -> st.nextToken()
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken(); // 공백x -> 한 줄 다 가져옴

			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(line.substring(j, j + 1)); // 한 개씩 잘라서 배열에 삽입
			}
		}
		BFS(0, 0);
		System.out.println(A[N - 1][M - 1]);
	}

	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j}); // 큐에 시작 데이터 삽입
		visited[i][j] = true;

		while (!queue.isEmpty()) { // 큐가 비어있을 때까지
			int now[] = queue.poll(); // 큐에서 데이터 꺼내기. 현재 노드

			for (int k = 0; k < 4; k++) { // 상하좌우 탐색
				// 다음 노드
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];

				// 다음 노드 유효성 검사
				if (x >= 0 && y >= 0 && x < N && y < M) { // 배열을 넘어가면 안됨
					if (A[x][y] != 0 && !visited[x][y]) { // 0이면 갈 수 없어서 안되고, 이미 방문했어도 안됨
						// 갈 수 있는 노드
						visited[x][y] = true;
						A[x][y] = A[now[0]][now[1]] + 1; // depth + 1 만들기
						queue.add(new int[] {x, y});
					}
				}
			}
		}
	}
}