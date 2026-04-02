import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            
            switch (command) {
                case 1:
                    // 1 X: X를 스택에 Push
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;
                    
                case 2:
                    // 2: Pop하고 출력, 비어있으면 -1 출력
                    if (stack.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(stack.pop()).append("\n");
                    }
                    break;
                    
                case 3:
                    // 3: 스택의 사이즈 출력
                    sb.append(stack.size()).append("\n");
                    break;
                    
                case 4:
                    // 4: 비어있으면 1, 아니면 0 출력
                    if (stack.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                    
                case 5:
                    // 5: 최상단 요소 출력 (제거 X), 비어있으면 -1 출력
                    if (stack.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(stack.peek()).append("\n");
                    }
                    break;
            }
        }
        
        System.out.print(sb.toString());
    }
}