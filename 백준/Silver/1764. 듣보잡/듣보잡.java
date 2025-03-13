import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> temp = new HashSet<>();
		for(int i = 0; i < N; i++) {
			temp.add(br.readLine());
		}

		Set<String> set = new HashSet<>();
		for(int i = 0; i < M; i++) {
			String person = br.readLine();
			if(temp.contains(person))
				set.add(person);
		}

		ArrayList<String> sortedList = new ArrayList<>(set);
		Collections.sort(sortedList);

		System.out.println(sortedList.size());
		for(String person : sortedList) {
			System.out.println(person);
		}

	}
}