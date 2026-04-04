import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();

            if (s.equals(".")) {
                break;
            }

            sb.append(solve(s)).append("\n");
        }

        System.out.print(sb);
    }

    public static String solve(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 열린 괄호는 종류에 상관없이 스택에 추가
            if (c == '(' || c == '[') {
                stack.push(c);
            } 
            // 닫힌 소괄호 처리
            else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                } else {
                    stack.pop();
                }
            } 
            // 닫힌 대괄호 처리
            else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}