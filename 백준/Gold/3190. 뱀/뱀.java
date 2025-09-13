import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = new int[] {0, 1, 0, -1};
	static int[] dc = new int[] {1, 0, -1, 0};
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean apple[][] = new boolean[N + 1][N + 1]; // 1 ~ N
		boolean body[][] = new boolean[N + 1][N + 1];
		Queue<Node> snake = new LinkedList<>();
		Queue<Turn> turnQueue = new LinkedList<>();

		// 사과 정보
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			apple[r][c] = true;
		}

		// 회전 정보
		int L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();

			turnQueue.add(new Turn(sec, dir));
		}

		snake.add(new Node(1, 1)); // 초기 위치
		Node head = snake.peek();
		body[head.r][head.c] = true;

		int dir = 0; // 초기 방향

		while (true) {
			count++;
			int nextR = head.r + dr[dir];
			int nextC = head.c + dc[dir];

			if (nextR >= 1 && nextR <= N && nextC >= 1 && nextC <= N) { // 범위 체크
				if (!body[nextR][nextC]) { // 자기자신의 몸과 부딪히는지 체크
					head = new Node(nextR, nextC);
					snake.add(head);
					body[head.r][head.c] = true;

					if (!apple[head.r][head.c]) {
						Node tail = snake.remove(); // 꼬리 줄어들기
						body[tail.r][tail.c] = false;
					} else {
						apple[head.r][head.c] = false;
					}
				} else
					break;
			} else
				break;

			if (!turnQueue.isEmpty()) {
				if(count == turnQueue.peek().sec) {
					String nextDir = turnQueue.poll().dir;
					if (nextDir.equals("L")) {
						dir = (dir + 3) % 4;
					} else {
						dir = (dir + 1) % 4;
					}
				}
			}
		}

		System.out.println(count);
	}
}

class Turn {
	int sec;
	String dir;

	Turn(int sec, String dir) {
		this.sec = sec;
		this.dir = dir;
	}
}

class Node {
	int r;
	int c;

	Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}