import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] lectures = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            lectures[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }
        
        // 시작 시간을 기준으로 오름차순 정렬
        Arrays.sort(lectures, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        // 각 강의실의 종료 시간을 관리할 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 첫 번째 수업의 종료 시간을 큐에 삽입
        pq.offer(lectures[0][1]);
        
        // 두 번째 수업부터 순회 시작
        for (int i = 1; i < N; i++) {
            // 현재 가장 빨리 끝나는 강의실 시간 -> 새로운 수업의 시작 시간
            // 빈 강의실이 있으므로 이어서 사용 가능
            if (pq.peek() <= lectures[i][0]) {
                pq.poll(); // 기존 강의실의 시간을 뺀다
            }
            
            // 이어서 쓰든, 새 강의실을 개설하든 현재 수업의 종료 시간을 큐에 넣음
            pq.offer(lectures[i][1]);
        }
        
        // 큐에 남아있는 종료 시간의 개수 -> 필요한 강의실의 개수
        System.out.println(pq.size());
    }
}