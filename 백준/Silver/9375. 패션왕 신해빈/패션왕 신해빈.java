import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        
		for(int i = 0; i < T; i++) {
			Map<String, List<String>> clothes = new HashMap<>();
			int N = Integer.parseInt(br.readLine());

			for(int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String cloth = st.nextToken();
				String type = st.nextToken();

				if(!clothes.containsKey(type)){
					List<String> clothList = new ArrayList<>();
					clothList.add(cloth);
					clothes.put(type, clothList);
				} else {
					clothes.get(type).add(cloth);
				}
			}
            
			int result = 1;
			for(String key : clothes.keySet()) {
				result *= clothes.get(key).size() + 1;
			}

			System.out.println(result - 1);
		}

	}
}