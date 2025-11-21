import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> recordsMap = new HashMap<>(); // 누적 시간
        Map<String, Integer> enterInfo = new HashMap<>(); // 주차된 차량
        
        for(String record : records) {
            String[] recordArr = record.split(" ");
            String[] timeArr = recordArr[0].split(":");
            
            int time = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
            String car = recordArr[1];
            String type = recordArr[2];
            
            if(type.equals("IN")) {
                enterInfo.put(car, time);
            } else {
                int enterTime = enterInfo.get(car);
                int totalMinute = time - enterTime;
                recordsMap.put(car, recordsMap.getOrDefault(car, 0) + totalMinute);
                enterInfo.remove(car);
            }
        }
        
        for(Map.Entry<String, Integer> entry : enterInfo.entrySet()) {
            String car = entry.getKey();
            int time = entry.getValue();
            
            recordsMap.put(car, recordsMap.getOrDefault(car, 0) + ((23 * 60) + 59) - time);
        }
        
        List<String> keyList = new ArrayList<>(recordsMap.keySet());
        Collections.sort(keyList);
        
        int[] answer = new int[keyList.size()];
        for(int i = 0; i < keyList.size(); i++) {
            int totalMinute = recordsMap.get(keyList.get(i));
            if(totalMinute <= fees[0]) {
                answer[i] = fees[1];
            } else {
                int extraTime = totalMinute - fees[0];
                boolean add = (extraTime % fees[2]) > 0;
                if(add) answer[i] = fees[1] + (extraTime/fees[2] + 1) * fees[3];
                else answer[i] = fees[1] + extraTime / fees[2] * fees[3];
            }
        }
        return answer;
    }
}
/*
출차 내역 없으면 23:59 출차로 간주
차랑별 누적 주차 시간 계산 후 정산 (여러번 입출차 가능)

누적 주차 시간이 기본 시간 이하 -> 기본 요금 청구
기본 시간 초과 -> 기본 요금 + 단위 요금 반영한거 // 단위로 안나눠떨어지면 올림하기


*/