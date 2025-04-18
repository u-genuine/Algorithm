/*
1. 장르별 인기순 1, 2위 모아
2. 장르 정렬 - 각 장르 2곡 재생수 합 높은 순 (내림차순)
3. 장르 내 2곡 정렬 - 재생 수 높은 순 (내림차순) -> 고유번호 낮은 순 (오름차순)

<String, Integer[2]>
<장르, {고유번호, 재생수}>

*/

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
                    
        int N = genres.length;
        ArrayList<Integer> album = new ArrayList<>();
        
        // <장르, 총 재생 수>
        Map<String, Integer> playCounts = new HashMap<>();
        
        // <장르, <고유번호, 재생수>>
        Map<String, Map<Integer, Integer>> numAndPlayCount = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
            playCounts.put(genres[i], playCounts.getOrDefault(genres[i], 0) + plays[i]);
                
            numAndPlayCount.putIfAbsent(genres[i], new HashMap<>());
            numAndPlayCount.get(genres[i]).put(i, plays[i]);
        }
        
        // 장르 정렬
        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(playCounts.entrySet());
        genreList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        
        // 장르 순회
        for(Map.Entry<String, Integer> map : genreList) {
            String genre = map.getKey();
            
            // 재생수, 고유번호 순으로 정렬
            Map<Integer, Integer> musicMap =  numAndPlayCount.get(genre);
            List<Map.Entry<Integer, Integer>> musicList = new ArrayList<>(musicMap.entrySet());
            
            musicList.sort((o1, o2) -> {
                if(o2.getValue() == o1.getValue()) {
                    return o1.getKey() - o2.getKey();
                }
                return o2.getValue() - o1.getValue();
            });
            
            album.add(musicList.get(0).getKey());
            if(musicList.size() > 1){
                album.add(musicList.get(1).getKey());
            }
        }
        
        int[] answer = album.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}