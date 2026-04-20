import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            int M = Integer.parseInt(br.readLine());
            
            sb.append((M + 1) / 2).append("\n");
            
            // 최대 힙
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            // 최소 힙
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            
            int count = 0; // 줄에 10개씩 출력하기 위한 카운터
            StringTokenizer st = null;
            
            for (int i = 0; i < M; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                int num = Integer.parseInt(st.nextToken());
                
                // 크기 규칙: 번갈아 가며 삽입, maxHeap부터 시작
                if (maxHeap.size() == minHeap.size()) {
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                }
                
                // 값 규칙: maxHeap의 최댓값이 minHeap의 최솟값보다 크면 교환
                if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                    int maxRoot = maxHeap.poll();
                    int minRoot = minHeap.poll();
                    
                    maxHeap.offer(minRoot);
                    minHeap.offer(maxRoot);
                }
                
                // 홀수 번째 입력마다 중앙값 출력
                if (i % 2 == 0) {
                    sb.append(maxHeap.peek()).append(" ");
                    count++;
                    
                    // 출력도 한 줄에 10개씩
                    if (count % 10 == 0) {
                        sb.append("\n");
                    }
                }
            }
            
            if (count % 10 != 0) {
                sb.append("\n");
            }
        }
        
        System.out.print(sb);
    }
}