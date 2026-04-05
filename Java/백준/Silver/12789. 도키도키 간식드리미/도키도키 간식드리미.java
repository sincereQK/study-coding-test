import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        int expected = 1; // 간식을 받아야 하는 현재 순번
        
        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(st.nextToken());
            
            // 스택의 맨 앞사람이 순서에 맞는지 먼저 확인
            while (!stack.isEmpty() && stack.peek() == expected) {
                stack.pop();
                expected++;
            }
            
            // 현재 줄의 맨 앞사람이 순서에 맞는지 확인
            if (current == expected) {
                expected++;
            } else {
                // 순서가 아니면 스택으로 이동
                stack.push(current);
            }
        }
        
        // 3. 기존 줄이 다 비워진 후, 스택에 남은 인원 처리
        while (!stack.isEmpty()) {
            if (stack.peek() == expected) {
                stack.pop();
                expected++;
            } else {
                // 스택의 맨 위가 다음 순서가 아니라면 더 이상 진행 불가
                break;
            }
        }
        
        // 스택이 완전히 비워졌는지 확인하여 결과 출력
        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}