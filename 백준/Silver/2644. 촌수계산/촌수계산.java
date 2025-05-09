import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int total = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int target1 = Integer.parseInt(st.nextToken());
		int target2 = Integer.parseInt(st.nextToken());

		if (target1 == target2) {
			System.out.println(0);
			return;
		}

		int edges = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] graph = new ArrayList[total + 1];
		for (int i = 1; i <= total; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < edges; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			graph[parent].add(child);
			graph[child].add(parent);
		}

		int[] distance = new int[total + 1];
		Arrays.fill(distance, -1);

		Queue<Integer> queue = new LinkedList<>();
		queue.add(target1);
		distance[target1] = 0;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			if (current == target2) {
				System.out.println(distance[current]);
				return;
			}

			for (int next : graph[current]) {
				if (distance[next] == -1) {
					distance[next] = distance[current] + 1;
					queue.add(next);
				}
			}
		}

		System.out.println(-1);
	}
}