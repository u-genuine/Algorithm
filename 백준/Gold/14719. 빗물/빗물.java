import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] height = new int[W];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;

		for (int i = 1; i < W - 1; i++) {
			int start = 0;
			int end = 0;

			for(int j = 0; j < i; j++) {
				start = Math.max(start, height[j]);
			}

			for(int j = i + 1; j < W; j++) {
				end = Math.max(height[j], end);
			}

			if(height[i] < start && height[i] < end) {
				result += Math.min(start, end) - height[i];
			}
		}

		System.out.println(result);
	}
}
