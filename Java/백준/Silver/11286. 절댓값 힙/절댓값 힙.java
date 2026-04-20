import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 절댓값 힙을 위한 우선순위 큐 커스텀 정렬 기준 설정
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            // 절댓값이 같다면 실제 값이 작은 쪽이 우선
            if (abs1 == abs2) {
                return o1 - o2;
            }
            // 절댓값이 다르다면 절댓값이 작은 쪽이 우선
            return abs1 - abs2;
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                // 큐가 비어있으면 0 출력, 아니면 가장 우선순위가 높은 값 출력 후 제거
                if (pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                // 0이 아니면 값을 힙에 추가
                pq.offer(x);
            }
        }

        System.out.print(sb);
    }
}