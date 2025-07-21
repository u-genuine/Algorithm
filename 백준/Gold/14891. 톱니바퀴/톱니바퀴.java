import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer[]> wheels;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		wheels = new ArrayList<>();
		wheels.add(new Integer[] {}); // 0번째 사용 x

		for (int i = 0; i < 4; i++) {
			String line = br.readLine();
			Integer[] temp = new Integer[8];
			for (int j = 0; j < line.length(); j++) {
				temp[j] = line.charAt(j) - '0';
			}
			wheels.add(temp);
		}

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());

			int left = wheels.get(num)[6];
			int right = wheels.get(num)[2];

			if (num > 1) {
				TurnLeftWheel(num - 1, left, dir * -1);
			}
			if (num < 4) {
				TurnRightWheel(num + 1, right, dir * -1);
			}

			turnWheel(num, dir);
		}

		int result = 0;
		for(int i = 1; i < 5; i++) {
			if(wheels.get(i)[0] == 1) {
				result += Math.pow(2, i - 1);
			}
		}

		System.out.println(result);
	}

	static void TurnLeftWheel(int thisNum, int left, int thisDir) {
		int thisRight = wheels.get(thisNum)[2];
		int thisLeft = wheels.get(thisNum)[6];

		if (thisRight == left) {
			return;
		}

		if (thisNum > 1) {
			TurnLeftWheel(thisNum - 1, thisLeft, thisDir * -1);
		}

		turnWheel(thisNum, thisDir);
	}

	static void TurnRightWheel(int thisNum, int right, int thisDir) {
		int thisRight = wheels.get(thisNum)[2];
		int thisLeft = wheels.get(thisNum)[6];

		if(thisLeft == right) {
			return;
		}

		if(thisNum < 4) {
			TurnRightWheel(thisNum + 1, thisRight, thisDir * -1);
		}

		turnWheel(thisNum, thisDir);
	}

	static void turnWheel(int thisNum, int dir) {
		Integer[] turnedWheel = new Integer[8];

		if (dir == 1) {
			turnedWheel[0] = wheels.get(thisNum)[7];
			for (int i = 1; i < 8; i++) {
				turnedWheel[i] = wheels.get(thisNum)[i - 1];
			}
		} else {
			for (int i = 0; i < 7; i++) {
				turnedWheel[i] = wheels.get(thisNum)[i + 1];
			}
			turnedWheel[7] = wheels.get(thisNum)[0];
		}

		wheels.add(thisNum, turnedWheel);
		wheels.remove(thisNum+1);
	}

}
