class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for (int h = 3; h <= Math.sqrt(total); h++) {
            if (total % h == 0) { // 약수인 경우
                int w = total / h; // 가로 길이 계산
              
                if ((w - 2) * (h - 2) == yellow) {
                    answer[0] = w;
                    answer[1] = h;
                    break;
                }
            }
        }
        
        return answer;
    }
}