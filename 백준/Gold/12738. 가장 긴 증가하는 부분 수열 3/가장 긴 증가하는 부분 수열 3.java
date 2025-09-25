import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> values = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            int pos = binarySearch(num, values);
            
            if(pos == values.size()) {
                values.add(num);
            } else {
                values.set(pos, num);
            }
        }

        System.out.println(values.size());
    }

    static int binarySearch(int num, List<Integer> values) {
        int idx1 = 0;
        int idx2 = values.size() - 1;

        while(idx1 <= idx2) {
            int mid = (idx1 + idx2) / 2;
            
            if(values.get(mid) < num) {
                idx1 = mid + 1;
            } else {
                idx2 = mid - 1;
            }
        }

        return idx1;
    }
}