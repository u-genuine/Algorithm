import java.io.*;

public class Main {
	static int N;
	static Long[][] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		memo = new Long[N + 1][10];

		long result = 0;
		for(int i = 0; i <= 9; i++) {
			result = (result + DP(N, i)) % 10007;
		}

		System.out.println(result);
	}

	static Long DP(int n, int start) {
		if(n == 1) {
			return 1L;
		}

		if(memo[n][start] != null) {
			return memo[n][start];
		}

		Long temp = 0L;
		for(int i = start; i <= 9; i++) {
			temp = (temp + DP(n - 1, i)) % 10007;
		}
		return memo[n][start] = temp;
	}
}