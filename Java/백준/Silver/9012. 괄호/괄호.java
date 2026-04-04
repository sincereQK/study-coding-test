import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < T; i++) {
            sb.append(solve(br.readLine())).append("\n");
        }
        
        System.out.print(sb);
    }
    
    // VPS(올바른 괄호 문자열)인지 판별하는 메서드
    public static String solve(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                // 열린 괄호는 스택에 추가
                stack.push(c);
            } else if (c == ')') {
                // 닫힌 괄호일 때 스택이 비어있다면 짝이 맞지 않음
                if (stack.isEmpty()) {
                    return "NO";
                } else {
                    // 짝이 맞으면 스택에서 제거
                    stack.pop();
                }
            }
        }
        
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}