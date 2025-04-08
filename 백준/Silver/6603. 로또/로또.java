import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());

			if(k == 0) break;

			int[] selectNum = new int[k];
			boolean[] visited = new boolean[k];
			for (int i = 0; i < k; i++) {
				selectNum[i] = Integer.parseInt(st.nextToken());
			}
			lotto(selectNum, visited, 0, 0);
			System.out.println();
		}
	}

	static void lotto(int[] selectNum, boolean[] visited, int index, int count){
		if(count == 6) {
			printNums(selectNum, visited);
			System.out.println();
		}

		for(int i = index; i < selectNum.length; i++) {
			visited[i] = true;
			lotto(selectNum, visited, i + 1, count + 1);
			visited[i] = false;
		}
	}

	static void printNums(int[] selectNum, boolean[] visited){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < selectNum.length; i++) {
			if(visited[i]) {
				sb.append(selectNum[i]).append(" ");
			}
		}
		System.out.print(sb);
	}
}
