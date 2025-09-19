import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        List<Record> viewList = new ArrayList<>();
        Map<String, String> nicknameMap = new HashMap<>(); // id, 닉네임
        
        for(String one : record) {
            String[] strSplit = one.split(" ");
            String act = strSplit[0];
            String id = strSplit[1];
            
            if(!act.equals("Leave")) {
                String nickname = strSplit[2];
                nicknameMap.put(id, nickname); // id가 존재하면 새 닉네임으로 대체됨 Map의 put() 메소드
            }
        
            if(!act.equals("Change")) {
                Record rec = new Record(id, act);
                viewList.add(rec);
            }
        }
        
        String[] answer = new String[viewList.size()];
        
        for(int i = 0; i < viewList.size(); i++) {
            Record one = viewList.get(i);
            String nickname = nicknameMap.get(one.id);
            String actEng = one.act;
            String actKor = actEng.equals("Enter") ? "들어왔습니다." : "나갔습니다.";
            
            String result = "";
            result += nickname;
            result += "님이 ";
            result += actKor;
            answer[i] = result;
        }
        
        return answer;
    }
}

class Record {
    String id;
    String act; 
    
    Record (String id, String act) {
        this.id = id;
        this.act = act;
    }
}