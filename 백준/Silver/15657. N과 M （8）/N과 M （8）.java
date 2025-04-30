import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		DFS(0, 0);
		System.out.println(sb);
	}

	static void DFS(int index, int count) {
		if(count == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i]).append(' ');
			}
			sb.append("\n");
			return;
		}

		for(int i = index; i < N; i++) {
			result[count] = arr[i];
			DFS(i, count + 1);
		}
	}
}