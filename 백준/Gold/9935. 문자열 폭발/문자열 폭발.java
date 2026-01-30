import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();
        int targetSize = target.length();

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            if(sb.length() >= targetSize) {
                boolean equal = true;
                for(int j = 0; j < targetSize; j++) {
                    if(sb.charAt(sb.length() - targetSize + j) != target.charAt(j)) {
                        equal = false;
                        break;
                    }
                }

                if(equal) {
                    sb.delete(sb.length() - targetSize, sb.length());
                }
            }
        }
        if(sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}