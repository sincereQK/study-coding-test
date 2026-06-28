import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] dist = new int[N];
        Arrays.fill(dist, -1);     // -1 = 아직 미방문
        dist[0] = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        while (!q.isEmpty()) {
            int cur = q.poll();
            // cur에서 1 ~ arr[cur] 칸 앞으로 점프
            for (int step = 1; step <= arr[cur]; step++) {
                int next = cur + step;
                if (next < N && dist[next] == -1) {   // 격자 안 + 미방문
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
        System.out.println(dist[N - 1]);   // 도달 못 했으면 -1 그대로
    }
}