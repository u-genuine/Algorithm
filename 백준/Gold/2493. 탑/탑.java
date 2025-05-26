import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Tower> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < N + 1; i++) {
			int height = Integer.parseInt(st.nextToken());

			if(stack.isEmpty()) {
				sb.append(0).append(" ");
				stack.push(new Tower(i, height));
			} else {
				while (true) {
					if(stack.isEmpty()) {
						sb.append(0).append(" ");
						stack.push(new Tower(i, height));
						break;
					}

					Tower temp = stack.peek();

					if (temp.height > height) {
						sb.append(temp.index).append(" ");
						stack.push(new Tower(i, height));
						break;
					} else {
						stack.pop();
					}
				}
			}
		}

		System.out.println(sb);
	}
}

class Tower {
	int index;
	int height;

	Tower(int index, int height) {
		this.index = index;
		this.height = height;
	}
}