import java.util.*;

class Solution {
    static List<String> allRoute = new ArrayList<>();
    static boolean[] visit;
    
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
        
        DFS("ICN", "ICN", tickets, 0);
        Collections.sort(allRoute);
        
        String[] answer = {};
        answer = allRoute.get(0).split(" ");
        
        return answer;
    }
    
    public void DFS(String start, String route, String[][] tickets, int count) {
        if(count == tickets.length) {
           allRoute.add(route);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(tickets[i][0].equals(start) && !visit[i]) {
                visit[i] = true;
                DFS(tickets[i][1], route + " " + tickets[i][1], tickets, count + 1);
                visit[i] = false;
            }
        }
    }
}