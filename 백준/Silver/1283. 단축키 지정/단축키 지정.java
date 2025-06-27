import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Set<String> set = new HashSet<>();

		int N = Integer.parseInt(br.readLine());
		ArrayList<String>[] options = new ArrayList[N];
		ArrayList<Integer>[] wordIdx = new ArrayList[N];

		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			options[i] = new ArrayList<>();
			wordIdx[i] = new ArrayList<>();

			String[] str = line.split("");
			wordIdx[i].add(0);
			for(int j = 0; j < str.length; j++) {
				if(str[j].equals(" ")) {
					wordIdx[i].add(j+1);
				}
				options[i].add(str[j]);
			}
		}

		for(int i = 0; i < N; i++) {
			boolean check = false;
			for(int j = 0; j < wordIdx[i].size(); j++) {
				int targetIdx = wordIdx[i].get(j);
				if(!set.contains(options[i].get(targetIdx).toLowerCase())) {
					set.add(options[i].get(targetIdx).toLowerCase());
					options[i].add(targetIdx, "[");
					options[i].add(targetIdx + 2, "]");
					check = true;
					break;
				}
			}

			if(!check) {
				for(int j = 0; j < options[i].size(); j++) {
					if(!set.contains(options[i].get(j).toLowerCase())) {
						if(!options[i].get(j).equals(" ")) {
							set.add(options[i].get(j).toLowerCase());
							options[i].add(j, "[");
							options[i].add(j + 2, "]");
							break;
						}
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < options[i].size(); j++) {
				sb.append(options[i].get(j));
			}
			sb.append("\n");
		}

		System.out.println(sb);

 	}
}