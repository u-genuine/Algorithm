import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] durability = new int[2 * N + 1];
		for(int i = 1; i < durability.length; i++) {
			durability[i] = Integer.parseInt(st.nextToken());
		}

		boolean[] robot = new boolean[N + 1];

		int stepCount = 0;
		while(true) {

			int zeroCount = 0;
			for(int i = 1; i < durability.length; i++) {
				if(durability[i] <= 0) {
					zeroCount++;
				}
			}

			if(zeroCount >= K) {
				break;
			}

			// 벨트 회전
			int temp = durability[durability.length - 1];
			for(int i = durability.length - 1; i > 1; i--) {
				durability[i] = durability[i - 1];
			}
			durability[1] = temp;

			for(int i = robot.length - 1; i > 1; i--) {
				robot[i] = robot[i - 1];
			}
			robot[1] = false;
			robot[robot.length - 1] = false;

			// 로봇 이동
			for(int i = robot.length - 1; i > 1; i--) {
				if(!robot[i] && robot[i-1] && durability[i] >= 1) {
					robot[i] = true;
					robot[i-1] = false;
					durability[i]--;
				}
			}

			if(durability[1] >= 1) {
				robot[1] = true;
				durability[1]--;
			}

			stepCount++;
		}

		System.out.println(stepCount);
	}
}