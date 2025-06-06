import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();;
	static List<String> stringList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			int[] numArr = new int[N + 1];
			for(int i = 1; i <= N; i++) {
				numArr[i] = i;
			}
			stringList = new ArrayList<>();
			DFS("" + numArr[1], numArr, 1, numArr[1], N, numArr[1], 1);

			Collections.sort(stringList);
			for(String s : stringList) {
				sb.append(s);
				sb.append("\n");
			}

			sb.append("\n");
		}

		System.out.println(sb);

	}

	static void DFS(String curStr, int[] numArr, int depth, int curValue, int n, int temp, int sign) {
		if(depth == n) {
			if(curValue == 0) {
				stringList.add(curStr);
			}
			return;
		}

		DFS(curStr + "+" + numArr[depth + 1], numArr, depth + 1, curValue + numArr[depth + 1], n, numArr[depth + 1], 1);
		DFS(curStr + "-" + numArr[depth + 1], numArr, depth + 1, curValue - numArr[depth + 1], n, numArr[depth + 1], -1);

		int combine = temp * 10 + numArr[depth + 1];
		int newValue = curValue - (sign * temp) + (sign * combine);
		DFS(curStr + " " + numArr[depth + 1], numArr, depth + 1, newValue, n, combine, sign);
	}
}