import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<Integer> setN = new HashSet<>();
        for(int i = 0; i < N; i++) {
            setN.add(sc.nextInt());    
        }
        
        int M = sc.nextInt();
        for(int i = 0; i < M; i++){
            if(setN.contains(sc.nextInt()))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}