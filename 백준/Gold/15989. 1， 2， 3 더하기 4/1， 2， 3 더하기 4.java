import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] dp = new int[10001][4];
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		int T = Integer.parseInt(br.readLine());
		for(int i = 4; i < 10001; i++) {
			dp[i][1] = dp[i-1][1];
			dp[i][2] = dp[i-2][1] + dp[i-2][2];
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			int target = Integer.parseInt(br.readLine());
			sb.append(dp[target][1] + dp[target][2] + dp[target][3]);
			sb.append("\n");
		}

		System.out.println(sb);
	}
}