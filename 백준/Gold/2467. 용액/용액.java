import java.util.*;
import java.io.*;
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] arr = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		int left = 0;
		int right = N - 1;
		long min = Long.MAX_VALUE;
		int tempL = 0;
		int tempR = 0;

		while(left < right) {
			long sum = arr[left] + arr[right];
			if(min > Math.abs(sum)){
				min = Math.abs(sum);
				tempL = left;
				tempR = right;
			}
			if(sum >= 0) {
				right--;
			}else {
				left++;
			}
		}

		System.out.println(arr[tempL] + " " + arr[tempR]);
	}
}