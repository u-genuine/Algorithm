import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int[] selected;
	static boolean[] visited;
	static int M;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		visited = new boolean[N];
		selected = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		DFS(0);
	}

	static void DFS(int count) {
		if (count == M) {
			for (int i = 0; i < M; i++)
				System.out.print(selected[i] + " ");
			System.out.println();
		} else {
			int before = 0;
			for (int i = 0; i < N; i++) {
				if (visited[i])
					continue;

				if (before != arr[i]) {
					visited[i] = true;
					selected[count] = arr[i];
					before = arr[i];
					DFS(count + 1);
					visited[i] = false;
				}
			}
		}
	}
}