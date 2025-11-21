import java.util.*;

class Solution {
    static Map<String, Integer> orderMap = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        for(String order : orders) {
            char[] orderArr = order.toCharArray();
            Arrays.sort(orderArr);
            
            for(int courseCnt : course) {
                combination(orderArr, courseCnt, 0, new StringBuilder());
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for(int courseCnt : course) {
            int maxCnt = 0;
            
            for(Map.Entry<String, Integer> entry : orderMap.entrySet()) {
                String setMenu = entry.getKey();
                int count = entry.getValue();
                int menuCnt = setMenu.length();

                if(menuCnt == courseCnt && count >= 2) {
                    maxCnt = Math.max(maxCnt, count);
                }
            }
            
            if(maxCnt >= 2) {
                for(Map.Entry<String, Integer> entry : orderMap.entrySet()) {
                    String setMenu = entry.getKey();
                    int count = entry.getValue();
                    int menuCnt = setMenu.length();
                    
                    if(menuCnt == courseCnt && count == maxCnt) {
                        result.add(setMenu);
                    }
                }
            }
        }
        
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
    
    static void combination(char[] orderArr, int targetCnt, int start, StringBuilder current) {
        
        if(current.length() == targetCnt) {
            String menu = current.toString();
            orderMap.put(menu, orderMap.getOrDefault(menu, 0) + 1);
            return;
        }
        
        for(int i = start; i < orderArr.length; i++) {
            current.append(orderArr[i]);
            combination(orderArr, targetCnt, i + 1, current);
            current.deleteCharAt(current.length()-1);
        }
    }
}

/*
손님들이 세트로 시키던 메뉴들을 코스 메뉴로 구성 (적어도 2명 이상이 시킨 조합에 한해서)
코스에 메뉴는 2개 이상
*/