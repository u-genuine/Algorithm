import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] value = new int[26];

        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            
            for(int j = 0; j < word.length(); j++) {
                value[word.charAt(j) - 'A'] += (int) Math.pow(10, word.length() - 1 - j);
            }
        }

        Arrays.sort(value);

        int result = 0;
        int num = 9;
        for(int i = 25; i >= 0; i--) {
            if(value[i] == 0) continue;
            result += value[i] * num;
            num--;
        }

        System.out.println(result);
    }
}