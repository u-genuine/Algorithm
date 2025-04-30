import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static boolean[] visited;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N];
		arr = new int[M];

		DFS(0);
		System.out.println(sb);
	}

	public static void DFS(int depth) {
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;
				DFS(depth + 1);
				visited[i] = false;
			}
		}
	}
}