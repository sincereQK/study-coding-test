
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int[] count = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'A']++;
        }
        
        int oddCount = 0;
        char midChar = 0;
        
        // 홀수 개인 알파벳 찾기
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                midChar = (char) (i + 'A'); // 정중앙에 들어갈 글자 기억하기
            }
        }
        
        // 홀수 개인 알파벳이 2개 이상이면 팰린드롬 불가
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        
        StringBuilder front = new StringBuilder();
        
        // A~Z순으로 절반씩 front에 이어 붙이기
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i] / 2; j++) {
                front.append((char) (i + 'A'));
            }
        }
        
        // 데칼코마니 조립: 앞부분 + (홀수일 때 중앙 글자) + 뒤집은 앞부분
        StringBuilder result = new StringBuilder();
        result.append(front);
        
        if (oddCount == 1) {
            result.append(midChar);
        }
        
        // 앞부분을 그대로 뒤집어서 뒤에 붙여준다
        result.append(front.reverse());
        
        System.out.println(result.toString());
    }
}