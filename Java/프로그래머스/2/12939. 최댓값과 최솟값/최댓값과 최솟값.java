import java.util.*;

class Solution {
    public String solution(String s) {
        // 공백을 기준으로 문자열 분리
        String[] arr = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        // 배열을 돌며 최댓값과 최솟값 갱신
        for (String str : arr) {
            int number = Integer.parseInt(str);
            
            if (number < min) min = number;
            if (number > max) max = number;
        }
        
        return min + " " + max;
    }
}
