import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long X = Integer.parseInt(st.nextToken());
		long Y = Integer.parseInt(st.nextToken());
		long Z = (Y * 100) / X ;

		if(Z >= 99) {
			System.out.println(-1);
			return;
		}

		long left = 1;
		long right = 1000000000;
		while (left <= right) {
			long mid = (left + right) / 2;
			long temp = (Y + mid) * 100 / (X + mid);

			if (temp <= Z) {
				left = mid + 1;
			} else if (temp > Z) {
				right = mid - 1;
			}
		}
		System.out.println(right+1);
	}
}