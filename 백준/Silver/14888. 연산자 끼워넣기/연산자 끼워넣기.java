import java.io.*;
import java.util.*;

class Main {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int N;
	static int[] operator = new int[4];
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		operator = new int[4];
		for(int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		calc(nums[0], 1);
		System.out.println(max);
		System.out.println(min);
	}

	static void calc(int tempResult, int index) {
		if(index == N) {
			min = Math.min(min, tempResult);
			max = Math.max(max, tempResult);
			return;
		}

		for(int i = 0; i < 4; i++){
			if(operator[i] == 0) {
				continue;
			}
			operator[i]--;
			switch(i) {
				case 0:
					calc(tempResult + nums[index], index + 1);
					break;
				case 1:
					calc(tempResult - nums[index], index + 1);
					break;
				case 2:
					calc(tempResult * nums[index], index + 1);
					break;
				case 3:
					calc(tempResult / nums[index], index + 1);
					break;
			}
			operator[i]++;
		}
	}

}