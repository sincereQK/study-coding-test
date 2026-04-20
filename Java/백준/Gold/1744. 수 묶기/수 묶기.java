import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // 양수 - 큰 수부터 꺼내기 위해 Max-Heap
        PriorityQueue<Integer> posHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 음수 - 작은 수(절댓값이 큰 수)부터 꺼내기 위해 Min-Heap
        PriorityQueue<Integer> negHeap = new PriorityQueue<>();
        
        int oneCount = 0;
        int zeroCount = 0;
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                posHeap.offer(num);
            } else if (num == 1) {
                oneCount++; // 1은 곱하는 것보다 더하는 게 무조건 이득
            } else if (num == 0) {
                zeroCount++; // 0은 남은 음수를 지우는 데 사용
            } else { // num < 0
                negHeap.offer(num);
            }
        }
        
        int sum = 0;
        
        // 양수 묶기 연산
        while (posHeap.size() >= 2) {
            int a = posHeap.poll();
            int b = posHeap.poll();
            sum += (a * b);
        }
        if (!posHeap.isEmpty()) {
            sum += posHeap.poll(); // 홀수 개라서 짝을 못 지은 양수는 그냥 더함
        }
        
        // 음수 묶기 연산
        while (negHeap.size() >= 2) {
            int a = negHeap.poll();
            int b = negHeap.poll();
            sum += (a * b); // - * - = +
        }
        if (!negHeap.isEmpty()) {
            // 짝을 못 지은 음수가 남았을 때, 0이 있다면 0과 곱해서 지움
            // 0이 없다면 총합에 더해서 감점 처리
            if (zeroCount == 0) {
                sum += negHeap.poll();
            }
        }
        
        sum += oneCount; // 1은 모아둔 개수만큼 그냥 더해준다
        
        System.out.println(sum);
    }
}