import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        // 요세푸스 순열 생성 로직
        while (q.size() > 1) {
            // K-1번 만큼 맨 앞 사람을 뒤로 보냄 (건너뛰기)
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }
            // K번째 사람을 완전히 제거하여 출력 버퍼에 추가
            sb.append(q.poll()).append(", ");
        }

        // 마지막 한 명 처리
        sb.append(q.poll()).append(">");
        
        System.out.println(sb);
    }
}