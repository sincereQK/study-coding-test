import java.util.*;

class Solution {
    boolean solution(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                count++; // Stack에 push하는 효과
            } else {
                // c == ')' 인 경우
                if (count == 0) {
                    // 꺼낼 '('가 없다면 이미 잘못된 괄호
                    return false;
                }
                count--; // Stack에서 pop하는 효과
            }
        }

        // 모든 문자열을 돌았을 때 count가 0이어야 완벽하게 짝이 맞는것
        return count == 0;
    }
}