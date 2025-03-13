import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			if (word.length() < M) {
				continue;
			}
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

		Collections.sort(list, (entry1, entry2) -> {
			int valueComparison = entry2.getValue().compareTo(entry1.getValue());

			if (valueComparison != 0) {
				return valueComparison;
			}

			int lengthComparison = Integer.compare(entry2.getKey().length(), entry1.getKey().length());

			if(lengthComparison != 0) {
				return lengthComparison;
			}

			return entry1.getKey().compareTo(entry2.getKey());
		});

        int size = list.size();
        for(int i = 0; i < size; i++) {
            sb.append(list.get(i).getKey());
            if(i < size - 1)
                sb.append("\n");
        }
        
        System.out.print(sb);
	}
}