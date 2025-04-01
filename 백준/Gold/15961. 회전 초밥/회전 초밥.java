import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int typeCount = 0;
		int idx1 = 1;
		int idx2 = k;

		int[] linearBelt = new int[N + k - 1];
		for (int i = 0; i < N; i++) {
			linearBelt[i] = Integer.parseInt(br.readLine());
		}
		for(int i = N; i < N + k - 1; i++) {
			linearBelt[i] = linearBelt[i - N];
		}

		Map<Integer, Integer> map = new HashMap<>();

		// 처음 k개 맵에 추가
		for(int i = 0; i < k; i++) {
			map.put(linearBelt[i], map.getOrDefault(linearBelt[i], 0) + 1);
		}
		typeCount = map.size();
		if(!map.containsKey(c)) {
			typeCount++;
		}

		while(idx2 < linearBelt.length) {
			if(map.get(linearBelt[idx1 - 1]) == 1) {
				map.remove(linearBelt[idx1 - 1]);
			} else {
				map.put(linearBelt[idx1 - 1], map.get(linearBelt[idx1 - 1]) - 1);
			}
			map.put(linearBelt[idx2], map.getOrDefault(linearBelt[idx2], 0) + 1);
			idx1++;
			idx2++;

			int temp = map.size();
			if(!map.containsKey(c)) {
				temp++;
			}
			typeCount = Math.max(typeCount, temp);
		}

		System.out.println(typeCount);
	}
}