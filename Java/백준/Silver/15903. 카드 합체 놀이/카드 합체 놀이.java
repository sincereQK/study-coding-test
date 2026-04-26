import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }
        
        // m번의 카드 합체 진행
        for (int i = 0; i < m; i++) {
            // 우선순위 큐 - 가장 작은 숫자 2개
            long card1 = pq.poll();
            long card2 = pq.poll();
            
            long sum = card1 + card2;
            
            // 더해진 새로운 값을 큐에 두 번 넣음
            pq.offer(sum);
            pq.offer(sum);
        }
        
        // m번의 합체가 끝난 후 큐에 남아있는 모든 카드의 합을 계산
        long totalSum = 0;
        while (!pq.isEmpty()) {
            totalSum += pq.poll();
        }
        
        System.out.println(totalSum);
    }
}