import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            
            if (x == 0) {
                // x가 0일 때: 큐가 비어있으면 0, 아니면 최솟값(루트 노드)을 뽑아서 추가
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                // x가 자연수일 때: 큐에 값을 추가
                pq.add(x);
            }
        }
        
        System.out.print(sb.toString());
    }
}