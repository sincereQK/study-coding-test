import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // 0: 큐, 1: 스택
        int[] type = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            type[i] = Integer.parseInt(st.nextToken());
        }
        
        // 큐의 원소들만 모아둘 덱 생성
        Deque<Integer> dq = new ArrayDeque<>();
        
        // 초기 원소 입력 및 덱 세팅
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            
            // 스택(1)은 무시하고, 큐(0)인 경우만 덱에 넣는다.
            // 오른쪽 큐의 원소가 먼저 출력되어야 하므로 addFirst() 사용
            if (type[i] == 0) {
                dq.addFirst(val);
            }
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // M개의 새로운 원소를 순서대로 삽입 및 출력
        for (int i = 0; i < M; i++) {
            int newVal = Integer.parseInt(st.nextToken());
            
            // 새로운 값은 뒤로 들어가고
            dq.addLast(newVal);
            
            // 기존에 있던 (혹은 방금 들어간) 값이 앞에서 나온다
            sb.append(dq.pollFirst()).append(" ");
        }
        
        System.out.println(sb);
    }
}