import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            
            switch (command) {
                case 1:
                    // 1 X: 덱의 앞에 넣는다
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    // 2 X: 덱의 뒤에 넣는다
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    // 3: 앞에서 빼고 출력 비었으면 -1
                    sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append("\n");
                    break;
                case 4:
                    // 4: 뒤에서 빼고 출력 비었으면 -1
                    sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append("\n");
                    break;
                case 5:
                    // 5: 원소의 개수 출력
                    sb.append(dq.size()).append("\n");
                    break;
                case 6:
                    // 6: 비어있으면 1 아니면 0
                    sb.append(dq.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 7:
                    // 7: 맨 앞의 원소 확인 비었으면 -1
                    sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append("\n");
                    break;
                case 8:
                    // 8: 맨 뒤의 원소 확인 비었으면 -1
                    sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append("\n");
                    break;
            }
        }
        
        System.out.print(sb);
    }
}