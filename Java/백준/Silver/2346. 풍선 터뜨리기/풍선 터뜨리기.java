import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Deque<int[]> dq = new ArrayDeque<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            dq.addLast(new int[]{i, Integer.parseInt(st.nextToken())});
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 빌 때까지 반복
        while (!dq.isEmpty()) {
            // 덱의 맨 앞 뽑기
            int[] current = dq.pollFirst();
            sb.append(current[0]).append(" ");
            
            // 마지막 풍선을 터뜨렸으면 이동할 필요 없이 바로 종료
            if (dq.isEmpty()) {
                break;
            }
            
            int move = current[1];
            
            // 양수: 오른쪽으로 이동
            if (move > 0) {
                // 이미 타겟 풍선이 뽑혔으므로 (move - 1)번만 뒤로 넘긴다
                for (int i = 0; i < move - 1; i++) {
                    dq.addLast(dq.pollFirst());
                }
            } 
            // 음수: 왼쪽으로 이동
            else {
                // 음수는 절댓값만큼 맨 뒤 요소를 앞으로 가져온다
                for (int i = 0; i < Math.abs(move); i++) {
                    dq.addFirst(dq.pollLast());
                }
            }
        }
        
        System.out.println(sb);
    }
}