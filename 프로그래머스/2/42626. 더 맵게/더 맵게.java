import java.util.*;
/*
scovile 크기순 정렬
count = 0
while(가장 작은게 k이상일 때까지 반복){
    가장 작은게 k보다 작으면
    가장 작은거, 두번쨰 작은거 배열에서 없애고 섞은 스코빌 지수를 배열에 넣고 정렬
    count++
}
return count

*/


class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville){
            pq.offer(s);
        }
        
        int count = 0;
        
        while(pq.peek() < K){
            if(pq.size() < 2){
                return -1;
            }
            
            int first = pq.poll();
            int second = pq.poll();
            
            int mix = first + (second * 2);
            pq.offer(mix);
            count ++;
        }
        
        return count;
    }
}