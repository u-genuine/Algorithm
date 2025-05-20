import java.io.*;

public class Main {
	static String S;
	static String T;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();

		dfs(T);

		System.out.println(answer);
	}

	static void dfs(String t) {
		int length = t.length();

		if(length == S.length()) {
			if(t.equals(S)) {
				answer = 1;
			} 
			return;
		}

		if(t.endsWith("A")) {
			dfs(t.substring(0, t.length()-1));
		}

		if(t.startsWith("B")) {
			dfs(new StringBuilder(t.substring(1)).reverse().toString());
		}
	}
}