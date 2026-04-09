import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new ArrayDeque<>();
        
        // 1번부터 N번까지의 카드를 큐에 세팅
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }
        
        // 카드가 1장 남을 때까지 반복
        while (q.size() > 1) {
            q.poll();           // 첫 번째 행동: 맨 위 카드를 버린다.
            q.offer(q.poll());  // 두 번째 행동: 그다음 맨 위 카드를 뽑아서 맨 아래로 넣는다.
        }
        
        // 마지막 남은 카드 출력
        System.out.println(q.poll());
    }
}