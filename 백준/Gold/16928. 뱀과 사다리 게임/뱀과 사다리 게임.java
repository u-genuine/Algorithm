import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] board = new int[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for(int i = 1; i <= 100; i++) {
			board[i] = i;
		}

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			board[from] = to;
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			board[from] = to;
		}

		int[] count = new int[101];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		count[1] = 0;

		while(true) {
			int current = queue.poll();

			for(int i = 1; i <= 6; i++) {
				int next = current + i;

				if(next > 100) continue;

				if(count[board[next]] == 0) {
					queue.add(board[next]);
					count[board[next]] = count[current] + 1;
				}

				if(board[next] == 100) {
					System.out.println(count[100]);
					return;
				}
			}

		}

	}
}