import java.io.*;
import java.util.*;

class Main {
	static int[] arr;
	static int[] selected;
	static boolean[] visited;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		selected = new int[N];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		DFS(0);

		System.out.println(sb);
	}

	static void DFS(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected[depth] = arr[i];
				DFS(depth + 1);
				visited[i] = false;
			}
		}
	}
}
