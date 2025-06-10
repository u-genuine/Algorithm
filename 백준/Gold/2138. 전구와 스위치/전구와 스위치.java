import java.io.*;
import java.util.*;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		String[] lightStr = br.readLine().split("");
		String[] targetStr = br.readLine().split("");

		boolean[] light = new boolean[N];
		boolean[] target = new boolean[N];

		for(int i = 0; i < lightStr.length; i++) {
			if(lightStr[i].equals("0")){
				light[i] = false;
			} else {
				light[i] = true;
			}

			if(targetStr[i].equals("0")) {
				target[i] = false;
			} else {
				target[i] = true;
			}
		}

		// i, i+1, i+2 번을 바꾸도록 할 예정이라
		// 0, 1번째만 스위칭 되는 경우를 위해 따로 처리
		boolean[] light2 = Arrays.copyOf(light, N);
		light2[0] = !light[0];
		light2[1] = !light[1];

		int answer1 = solve(light, target);
		int answer2 = solve(light2, target);
		if(answer2 != -1) {
			answer2++;
		}

		if(answer1 == -1) {
			System.out.println(answer2);
		} else if (answer2 == -1) {
			System.out.println(answer1);
		} else {
			System.out.println(Math.min(answer1, answer2));
		}

	}

	static int solve(boolean[] light, boolean[] target) {
		int count = 0;

		for(int i = 0; i < N - 1; i++) {
			if(light[i] != target[i]) {
				count++;
				light[i] = !light[i];
				light[i+1] = !light[i+1];
				if(i != N-2) {
					light[i+2] = !light[i+2];
				}

			}
		}

		return light[N-1] != target[N-1] ? -1 : count;
	}
}