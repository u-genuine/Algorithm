import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] num;
	static int[] operator = new int[4];
	static long max = Long.MIN_VALUE;
	static long min = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		num = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		DFS(num[0], 1);
		System.out.println(max);
		System.out.println(min);
	}

	static void DFS(long curVal, int nextIdx) {
		if(nextIdx == N) {
			max = Math.max(max, curVal);
			min = Math.min(min, curVal);
			return;
		}

		for(int i = 0; i < 4; i++) {
			if(operator[i] > 0) {
				long nextValue = operate(curVal, num[nextIdx], i);
				operator[i]--;
				DFS(nextValue, nextIdx + 1);
				operator[i]++;
			}
		}
	}

	static long operate(long num1, long num2, int opIdx) {
		long result = 0;
		switch(opIdx) {
			case 0:
				result = num1 + num2;
				break;
			case 1:
				result = num1 - num2;
				break;
			case 2:
				result = num1 * num2;
				break;
			case 3:
				result = num1 / num2;
				break;
		}

		return result;
	}
}