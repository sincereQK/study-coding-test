import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // back() 명령을 쉽게 처리하기 위해 Deque 사용
        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            switch (command) {
                case "push":
                    // 큐의 뒤에 요소 추가
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;
                    
                case "pop":
                    // 큐의 맨 앞 요소 제거 및 반환
                    Integer item = q.poll();
                    if (item == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(item).append("\n");
                    }
                    break;
                    
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                    
                case "empty":
                    if (q.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                    
                case "front":
                    // 큐의 맨 앞 요소 확인 (제거 X)
                    Integer it = q.peek();
                    if (it == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(it).append("\n");
                    }
                    break;
                    
                case "back":
                    // 큐의 맨 뒤 요소 확인 (Deque에서만 지원하는 peekLast 활용)
                    Integer last = q.peekLast();
                    if (last == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(last).append("\n");
                    }
                    break;
            }
        }
        
        System.out.print(sb);
    }
}