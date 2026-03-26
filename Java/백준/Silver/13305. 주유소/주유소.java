import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] dist = new long[N-1];
        long[] cost = new long[N];

        for (int i = 0; i < N -1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long totalCost = 0;
        long minCost = dist[0]; // 출발할 때는 무조건 첫 번째 도시의 기름을 넣어야 함

        // 도시를 하나씩 지나가면서 계산
        for (int i = 0; i < N - 1; i++) {
            // 지금 도착한 도시의 기름값이 내가 알던 최저가 보다 싼가?
            if (cost[i] < minCost) {
                // 싸다면 최저가를 바꾼다. 여기서 기름을 넣음
                minCost = cost[i];
            }
            // 이동할 거리 만큼 현재 까지 발견한 가장 싼 각격으로 결제해서 누적시킴
            totalCost += (minCost * dist[i]);
        }

        System.out.println(totalCost);

    }
}
