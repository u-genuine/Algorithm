import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] alphabet = new int[26];

		String target = br.readLine();
		for(int i = 0; i < target.length(); i++) {
			alphabet[target.charAt(i) - 'A']++;
		}

		int result = 0;

		for(int i = 0; i < n - 1; i++) {
			int[] temp = new int[26];
			String current = br.readLine();
			for (int j = 0; j < current.length(); j++) {
				temp[current.charAt(j) - 'A']++;
			}

			int sum = 0;
			for (int j = 0; j < 26; j++) {
				sum += Math.abs(alphabet[j] - temp[j]);
			}

			if (sum <= 1 || (sum == 2 && target.length() == current.length())) {
				result++;
			}
		}
        
		System.out.println(result);
		
	}
}