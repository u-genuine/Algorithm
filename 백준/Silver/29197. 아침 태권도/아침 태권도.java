import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		Set<Double> set1 = new HashSet<>();
		Set<Double> set2 = new HashSet<>();

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());

			double lean = (double) Y/X;
			if(Y >= 0) {
				set1.add(lean);
			} else {
				set2.add(lean);
			}
		}

		System.out.println(set1.size() + set2.size());
	}
}