import java.util.*;

class Main {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] arr = new int[T];
		int[] dp = new int[T];		

		for(int i = 0; i < T; i++) {
			arr[i] = sc.nextInt();
		}

		dp[0] = arr[0];
        int max = dp[0];

		for(int i = 1; i < T; i++) {
			dp[i] = arr[i];

			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
				if(max < dp[i]) {
					max = dp[i];
				}
			}
		}
		System.out.println(max);
	}
}