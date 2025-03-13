import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int total = 0;
		String tree;
		HashMap<String, Integer> treeMap = new HashMap<>();
		while((tree = br.readLine()) != null) {
			total++;
			treeMap.put(tree, treeMap.getOrDefault(tree, 0) + 1);
		}

		List<Map.Entry<String, Integer>> treeList = new ArrayList<>(treeMap.entrySet());
		Collections.sort(treeList, Comparator.comparing(Map.Entry::getKey));

		for(Map.Entry<String, Integer> entry : treeList) {
			Double percent = (double) entry.getValue() / total;
			sb.append(entry.getKey() + " " + String.format("%.4f", percent * 100) + "\n");
		}

		System.out.print(sb);
	}
}