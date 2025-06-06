import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ArrayList<String>[] options = new ArrayList[N];
		ArrayList<Integer>[] wordIdx = new ArrayList[N];

		for(int i = 0; i < options.length; i++) {
			options[i] = new ArrayList<>();
			String line = br.readLine();
			for(String str : line.split("")) {
				options[i].add(str);
			}
		}

		for(int i = 0; i < options.length; i++) {
			ArrayList<String> option = options[i];
			int size = option.size();

			wordIdx[i] = new ArrayList<>();
			wordIdx[i].add(0);

			for(int j = 0; j < size; j++) {
				if(option.get(j).equals(" ")) {
					wordIdx[i].add(j + 1);
				}
			}
		}

		Set<String> set = new HashSet<>();

		for(int i = 0; i < options.length; i++) {
			boolean find = false;
			for(int idx : wordIdx[i]) {
				if(!set.contains(options[i].get(idx).toLowerCase())) {
					set.add(options[i].get(idx).toLowerCase());
					options[i].add(idx, "[");
					options[i].add(idx + 2, "]");
					find = true;
					break;
				}
			}

			if(find) {
				continue;
			}

			for(int j = 0; j < options[i].size(); j++) {
				if(options[i].get(j).equals(" "))
					continue;
				
				if(!set.contains(options[i].get(j).toLowerCase())) {
					set.add(options[i].get(j).toLowerCase());
					options[i].add(j, "[");
					options[i].add(j + 2, "]");
					break;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(ArrayList<String> option : options) {
			for(String s : option) {
				sb.append(s);
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}
}