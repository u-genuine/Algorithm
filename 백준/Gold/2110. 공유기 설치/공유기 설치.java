import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long[] housePos = new long[N];
		for (int i = 0; i < N; i++) {
			housePos[i] = Long.parseLong(br.readLine());
		}

		Arrays.sort(housePos);

		long left = 1;
		long right = housePos[N-1] - housePos[0];

		while(left <= right) {
			long mid = (left + right) / 2;

			int count = 1;
			long lastPos = housePos[0];

			for(int i = 1; i < N; i++){
				if(housePos[i] >= lastPos + mid){
					count++;
					lastPos = housePos[i];
				}
			}

			if(count < C) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(right);

	}
}