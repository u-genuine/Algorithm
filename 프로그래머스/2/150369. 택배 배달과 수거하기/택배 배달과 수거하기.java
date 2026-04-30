import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        // 집까지 거리(인덱스 + 1), 택배 개수
        Deque<int[]> deliveryStack = new ArrayDeque<>(); 
        Deque<int[]> pickupStack = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++) {
            if(deliveries[i] > 0) deliveryStack.push(new int[]{i + 1, deliveries[i]});
            if(pickups[i] > 0) pickupStack.push(new int[]{i + 1, pickups[i]});
        }
        
        while(!deliveryStack.isEmpty() || !pickupStack.isEmpty()) {
            int dist = 0;
            if(!deliveryStack.isEmpty()) dist = Math.max(dist, deliveryStack.peek()[0]);
            if(!pickupStack.isEmpty()) dist = Math.max(dist, pickupStack.peek()[0]);
            answer += dist * 2 ; 

            int tmpDelivery = 0;
            while(tmpDelivery < cap && !deliveryStack.isEmpty()) {
                int[] top = deliveryStack.peek();
                if(tmpDelivery + top[1] <= cap) {
                    tmpDelivery += top[1];
                    if(deliveryStack.isEmpty()) break;
                    deliveryStack.pop();
                } else {
                    top[1] -= (cap - tmpDelivery);
                    break;
                }
            }

            int tmpPickup = 0;
            while(tmpPickup < cap && !pickupStack.isEmpty()) {
                int[] top = pickupStack.peek();
                if(tmpPickup + top[1] <= cap) {
                    tmpPickup += top[1];
                    if(pickupStack.isEmpty()) break;
                    pickupStack.pop();
                } else {
                    top[1] -= (cap - tmpPickup);
                    break;
                }
            }
        }
        
        return answer;
    }
}
/*
1. 배달 안 된 집 중 가장 먼 집 찾기
2. 수거 안 된 집 중 가장 먼 집 찾기
3. 둘 중 더 먼 집까지 왕복 거리 추가 -> max(가장 먼 배달 집, 가장 먼 수거 집) * 2
4. 그 왕복 안에서 cap만큼 배달하고 cap만큼 수거
*/