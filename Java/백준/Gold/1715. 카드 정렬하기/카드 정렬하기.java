import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 입력받은 카드를 전부 우선순위 큐에 넣음
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 왜 우선순위 큐를 사용하게 되었는가
        // 원래는 (A+B) + ((A+B)+C) 와 같은 형식으로 오름차순으로 진행하였음
        // 다만 10, 10, 10, 10 처럼 차례대로 하는게 아니라 (10,10) (10,10)의 형태로 묷는것이 더 이득인 경우가 존재
        // 그래서 우선 순위 큐에서 항상 가장 작은 두 숫자를 꺼내서 더하는것으로 변경
        // 10, 10, 10, 10 -> 10, 10, 20 -> 20, 20
        // 이런 형식이 더 이득이므로 항상 작은 숫자를 가져오는 우선순위큐로 구현

        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int total = 0;

        while (pq.size() > 1) {
            int min1 = pq.poll();
            int min2 = pq.poll();
            int sum = min1 + min2;
            total += sum;

            pq.offer(sum);
        }

        System.out.println(total);
    }
}
