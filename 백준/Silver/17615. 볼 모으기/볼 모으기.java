import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] balls = new String[N];
		balls = br.readLine().split("");

		int RCount = 0;
		int BCount = 0;
		for(String ball : balls) {
			if(ball.equals("R")) {
				RCount++;
			} else {
				BCount++;
			}
		}

		int result = Integer.MAX_VALUE;

		int leftR = 0;
		for(int i = 0; i < N; i++) {
			if(balls[i].equals("R")) {
				leftR++;
			} else {
				break;
			}
		}

		result = Math.min(result, RCount - leftR);

		int rightR = 0;
		for(int i = N-1 ; i >= 0; i--) {
			if(balls[i].equals("R")) {
				rightR++;
			} else {
				break;
			}
		}

		result = Math.min(result, RCount - rightR);

		int leftB = 0;
		for(int i = 0; i < N; i++) {
			if(balls[i].equals("B")) {
				leftB++;
			} else {
				break;
			}
		}

		result = Math.min(result, BCount - leftB);

		int rightB = 0;
		for(int i = N - 1; i >= 0; i--) {
			if(balls[i].equals("B")) {
				rightB++;
			} else {
				break;
			}
		}

		result = Math.min(result, BCount - rightB);

		System.out.println(result);
	}
}