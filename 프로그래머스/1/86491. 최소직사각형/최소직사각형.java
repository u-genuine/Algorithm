class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;
        
        for(int[] card : sizes) {
            // 가로, 세로 중 긴변이 width, 짧은 변이 height
            // 모든 명함 중 가장 긴 width, height를 찾기
            width = Math.max(width,  Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        
        return width * height;
    }
}