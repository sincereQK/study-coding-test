import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                
                // 큐에 아직 N개가 안 찼으면 그냥 넣기
                if (pq.size() < N) {
                    pq.offer(num);
                } 
                // 큐가 N개로 꽉 찼다면, 최솟값과 비교해서 교체
                else {
                    if (pq.peek() < num) {
                        pq.poll(); // 기존에 들고 있던 것 중 가장 작은 놈을 쫓아냄
                        pq.offer(num); // 더 큰 놈을 영입
                    }
                }
            }
        }
        
        System.out.println(pq.peek());
    }
}