import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[1000001];

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {N, 0});

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int X = current[0];
			int sec = current[1];

			if (X == K) {
				System.out.println(sec);
				return;
			}
			if (visited[X] || X >= 200000) {
				continue;
			}

			int[] nextPos = {X - 1, X + 1, X * 2};

			for (int next : nextPos) {
				if (next < 0 || next > 100000 || visited[next]) {
					continue;
				}

				visited[X] = true;
				queue.add(new int[] {next, sec + 1});
			}
		}
	}
}