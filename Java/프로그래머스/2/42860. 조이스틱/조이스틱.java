class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        // 가장 기본적으로 오른쪽으로만 쭉 이동했을 때의 횟수
        int minMove = length - 1; 
        
        for (int i = 0; i < length; i++) {
            // 알파벳 변경 횟수 계산 (위/아래 중 최소)
            char target = name.charAt(i);
            answer += Math.min(target - 'A', 'Z' - target + 1);
            
            // 연속된 'A' 구간의 끝(nextIdx) 찾기
            int nextIdx = i + 1;
            while (nextIdx < length && name.charAt(nextIdx) == 'A') {
                nextIdx++;
            }
            
            // 좌/우 커서 이동 최적의 경로 찾기
            // 오른쪽으로 갔다 턴하기 / 왼쪽으로 먼저 갔다 턴하기 / 그냥 한 방향으로 가기
            minMove = Math.min(minMove, i * 2 + (length - nextIdx)); // 오른쪽으로 가다 턴
            minMove = Math.min(minMove, (length - nextIdx) * 2 + i); // 왼쪽으로 먼저 가다 턴
        }
        
        // 알파벳 변경 총합 + 최적의 커서 이동 횟수
        return answer + minMove;
    }
}