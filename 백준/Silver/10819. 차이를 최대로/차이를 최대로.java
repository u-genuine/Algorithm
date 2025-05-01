import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] nums;
	static boolean[] visited;
	static int max = -1;
	static List<Integer> arr = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		visited = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		DFS(0);
		System.out.println(max);
	}
	static void DFS(int count) {
		if(count == N) {
			max = Math.max(max, getResult());
			return;

		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr.add(nums[i]);
				DFS(count + 1);
				visited[i] = false;
				arr.remove(count);
			}
		}
	}

	static int getResult() {
		int sum = 0;
		for(int i = 0; i < N - 1; i++) {
			sum += Math.abs(arr.get(i) - arr.get(i + 1));
		}
		return sum;
	}
}