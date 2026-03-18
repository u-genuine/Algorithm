class Solution {
    static List<String> sttWordDict;
    static Set<Integer> visited;

    public boolean wordBreak(String s, List<String> wordDict) {
        visited = new HashSet<>();
        sttWordDict = wordDict;
        return DFS(s, 0);
    }

    public boolean DFS(String s, int start) {
        if (start == s.length()) return true;
        if (visited.contains(start)) return false;

        for(String word : sttWordDict) {
            if (start + word.length() > s.length()) continue;
            if (s.substring(start, start + word.length()).equals(word)) {
                boolean temp = DFS(s, start + word.length());
                if(temp) return temp;
            }
        }
        visited.add(start);
        return false;
    }
}