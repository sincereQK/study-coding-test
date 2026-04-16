import java.util.*;

class Solution {
    public String solution(String number, int k) {
        // 큰수를 만들자.
        // 앞자리가 클수로 큰 숫자가 된다.
        // 문자열을 내림차순으로 정리 -> 이 형식으로 진행하면 안됨
        // 1924를 정렬로 만들면 9421이 되는데 여기서 94를 뽑을 수는 있음
        // 1231234를 정렬하면 4332211 -> 근데 문제는 3234임
        // 그러니까 1231234에서 3개만 빼서 만들수있는 수를 말하는거임
        // 주어진 number에서 k개를 뻇을때 만들수있는수다.
        // 정렬이 아님 숫자 순서를 바꾸는거는 안됨.
        // 숫자 순서를 유지 -> 스택 사용
        
        StringBuilder sb = new StringBuilder();
        
        int size = number.length();
        
        for (int i = 0; i < size; i++) {
            char current = number.charAt(i);
            
            // 스택(StringBuilder)이 비어있지않고 & 아직 삭제 횟수가 남아있고 & 스택의 마지막 숫자보다 현재 숫자가 크면
            // 스택의 마지막 숫자를 지우고 횟수를 줄인다.
            while (sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) < current) {
                sb.deleteCharAt(sb.length() -1);
                k--;
            }
            
            sb.append(current);
            
        }
                   
        
        String answer = sb.substring(0, sb.length() - k);
        return answer;
    }
}