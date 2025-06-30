import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if(K <= N) {
			System.out.println(N-K);
			return;
		}

		int[] arr = new int[100001];
		boolean[] visited = new boolean[100001];

		arr[N] = 0;
		Deque<Node> queue = new ArrayDeque<>();
		queue.addFirst(new Node(N, 0));

		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			visited[cur.index] = true;
			if(cur.index == K) {
				System.out.println(cur.time);
				break;
			}

			if(cur.index * 2 <= 100000 && !visited[cur.index * 2]) {
				queue.addFirst(new Node(cur.index * 2, cur.time));
			}

			if(cur.index + 1 <= 100000 && !visited[cur.index + 1]) {
				queue.add(new Node(cur.index + 1, cur.time + 1));
			}

			if(cur.index - 1 >= 0 && !visited[cur.index - 1]) {
				queue.add(new Node(cur.index - 1, cur.time + 1));
			}
		}
 	}
}

class Node {
	int index;
	int time;

	Node(int index, int time) {
		this.index = index;
		this.time = time;
	}
}