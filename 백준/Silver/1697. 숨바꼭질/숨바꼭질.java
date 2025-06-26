import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] result = new int[100001];
		result[n] = 0;
		boolean[] visited = new boolean[100001];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		visited[n] = true;

		while(!queue.isEmpty()) {
			int cur = queue.poll();

			if(cur == k) {
				System.out.println(result[cur]);
				break;
			}

			if(cur + 1 < 100001 && !visited[cur + 1]) {
				queue.add(cur + 1);
				result[cur + 1] = result[cur] + 1;
				visited[cur + 1] = true;
			}
			if(cur - 1 >= 0 && !visited[cur - 1]) {
				queue.add(cur - 1);
				result[cur - 1] = result[cur] + 1;
				visited[cur - 1] = true;
			}
			if(cur * 2 < 100001 && !visited[cur * 2]) {
				queue.add(cur * 2);
				result[cur * 2] = result[cur] + 1;
				visited[cur * 2] = true;
			}
		}
 	}
}