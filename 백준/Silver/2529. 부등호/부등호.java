import java.awt.print.Pageable;
import java.io.*;
import java.util.*;

public class Main {
	static int K;
	static boolean[] visit = new boolean[10];
	static char[] operators;
	static List<String> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());

		operators = new char[K];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			operators[i] = st.nextToken().charAt(0);
		}

		for (int i = 0; i < 10; i++) {
			visit[i] = true;
			DFS(i, 0, i + "");
			visit[i] = false;
		}
		System.out.println(result.get(result.size()-1));
		System.out.println(result.get(0));
	}

	static void DFS(int now, int count, String number) {
		if (count == K) {
			result.add(number);
			return;
		}
		for (int next = 0; next < 10; next++) {
			if (!visit[next]) {
				if ((operators[count] == '<' && now < next) ||
					(operators[count] == '>' && now > next)) {
					visit[next] = true;
					DFS(next, count + 1, number + next);
					visit[next] = false;
				}
			}
		}
	}

	static void DFS_ASC(int node) {
	}

}