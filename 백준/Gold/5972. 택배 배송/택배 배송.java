import java.io.*;
import java.util.*;

class Edge {
	int to;
	int cost;

	Edge(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Edge>[] graph = new ArrayList[N+1];
		for(int n = 1; n < N+1; n++) {
			graph[n] = new ArrayList<>();
		}

		boolean[] visit = new boolean[N+1];
		int[] dist = new int[N+1];

		Arrays.fill(dist, Integer.MAX_VALUE);

		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int barn1 = Integer.parseInt(st.nextToken());
			int barn2 = Integer.parseInt(st.nextToken());
			int cow = Integer.parseInt(st.nextToken());

			graph[barn1].add(new Edge(barn2, cow));
			graph[barn2].add(new Edge(barn1, cow));
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.add(new int[]{1, 0});
		dist[1] = 0;

		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curBarn = cur[0];
			int cost = cur[1];

			if(visit[curBarn] || cost > dist[curBarn]) {
				continue;
			}

			visit[curBarn] = true;

			if(curBarn == N) {
				System.out.println(cost);
				break;
			}

			for(Edge edge : graph[curBarn]) {
				int nextBarn = edge.to;
				int nextCost = cost + edge.cost;

				if(!visit[nextBarn] && nextCost < dist[nextBarn]) {
					dist[nextBarn] = nextCost;
					pq.add(new int[] {nextBarn, nextCost});
				}
			}
		}
	}
}