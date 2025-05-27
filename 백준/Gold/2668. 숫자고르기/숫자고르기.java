import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];

		Set<Integer> set = new HashSet<>();

		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			set.add(arr[i]);
		}

		while(true) {
			Set<Integer> temp = new HashSet<>();

			for(int num : set) {
				temp.add(arr[num]);
			}

			if(temp.size() == set.size()) {
				break;
			}

			set = temp;
		}

		List<Integer> result = new ArrayList<>(set);
		Collections.sort(result);

		System.out.println(result.size());
		StringBuilder sb = new StringBuilder();
		for(int i : result) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
}
