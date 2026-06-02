class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length;

        for (int i = 1; i < height; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                
                if (j == 0) {
                    // 맨 왼쪽 바로 위 칸에서만 내려옴
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == triangle[i].length - 1) {
                    // 맨 오른쪽 바로 위 왼쪽 칸에서만 내려옴
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    // 중간은 왼쪽 위와 오른쪽 위 중 큰 값을 선택
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }

        // 마지막 줄에서 가장 큰 값
        for (int val : triangle[height - 1]) {
            answer = Math.max(answer, val);
        }

        return answer;
    }
}