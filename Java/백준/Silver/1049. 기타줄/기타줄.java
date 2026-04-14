import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int minPackage = 1000;
        int minSingle = 1000;
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            
            // 모든 브랜드 중 가장 싼 패키지 가격과 낱개 가격만 갱신
            minPackage = Math.min(minPackage, p);
            minSingle = Math.min(minSingle, s);
        }
        
        // 전부 낱개로 사는 경우
        int cost1 = N * minSingle;
        
        // 패키지 + 낱개 조합으로 딱 맞춰서 사는 경우
        int cost2 = (N / 6) * minPackage + (N % 6) * minSingle;
        
        // 전부 패키지로 사는 경우 (N개를 초과해서 사더라도 쌀 수 있음)
        // N이 6의 배수라면 이미 cost2에서 최적값이 계산되므로 오버슈팅(+1)만 고려
        int cost3 = ((N / 6) + 1) * minPackage;
        
        // 가장 비용이 적게 드는 값을 찾음
        int minCost = Math.min(cost1, Math.min(cost2, cost3));
        
        System.out.println(minCost);
    }
}