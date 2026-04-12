import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int F = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int[] dp = new int[F + 2];
            dp[1] = 0; // 후보가 1개면 이미 찾은 것이므로 비용 0
            
            for (int i = 2; i <= F + 1; i++) {
                int minCost = Integer.MAX_VALUE;
                
                for (int x = 1; x < i; x++) {
                    // 깨졌을 경우: 유리 비용 + 총알 비용 + 남은 x개 중 찾는 비용
                    // 안 깨졌을 경우: 총알 비용 + 남은 i-x개 중 찾는 비용
                    // 두 경우 중 더 비용이 큰 최악의 상황을 대비합니다.
                    int worstCaseCost = B + Math.max(G + dp[x], dp[i - x]);
                    
                    // 그 최악의 상황 중에서도 가장 돈이 적게 드는 테스트 위치를 찾습니다.
                    if (worstCaseCost < minCost) {
                        minCost = worstCaseCost;
                    }
                }
                dp[i] = minCost;
            }
            
            sb.append("Case #").append(t).append(": ").append(dp[F + 1]).append("\n");
        }

        System.out.print(sb);
    }
}