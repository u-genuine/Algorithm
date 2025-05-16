import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	static int[] time;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		time = new int[100001];
		visit = new boolean[100001];

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {n, 0});
		visit[n] = true;

		while(!q.isEmpty()) {
			int[] current = q.poll();

			if(current[0] == k) {
				System.out.println(current[1]);
				return;
			}
			for(int i = 0; i < 3; i++) {
				int next;
				int time;
				if(i == 0){
					next = current[0] * 2;
					time = current[1];
				} else if(i == 1){
					next = current[0] - 1;
					time = current[1] + 1;
				} else {
					next = current[0] + 1;
					time = current[1] + 1;
				}

				if(next >= 0 && next <= 100000 && !visit[next]) {
					q.add(new int[] {next, time});
					visit[next] = true;
				}
			}
		}

	}
}