import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		List<List<Node>> adj = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) {
			adj.add(new ArrayList<>());
		}

		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());

			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			adj.get(p).add(new Node(q, r));
			adj.get(q).add(new Node(p, r));
		}

		for(int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			

			boolean[] visited = new boolean[N+1];

			Queue<Node> queue = new LinkedList<>();
			queue.add(new Node(start, Integer.MAX_VALUE));

			visited[start] = true;
			int count = 0;

			while(!queue.isEmpty()) {
				Node cur = queue.poll();

				for(Node next : adj.get(cur.to)) {
					if(!visited[next.to] && next.usado >= k) {
						visited[next.to] = true;
						queue.add(next);
						count++;
					}
				}
			}
			System.out.println(count);
		}
 	}
}

class Node {
	int to;
	int usado;

	public Node(int to, int usado) {
		this.to = to;
		this.usado = usado;
	}
}