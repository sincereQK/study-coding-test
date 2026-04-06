import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // N이 1일 때는 배열 크기 및 인덱스 접근 오류를 막기 위해 바로 예외 처리
        if (N == 1) {
            System.out.println(1);
            return;
        }
        
        // DP를 위한 배열 생성
        int[] dp = new int[N + 1];
        
        dp[1] = 1;
        dp[2] = 2;
        
        // 바텀업방식으로 N까지 계산
        for (int i = 3; i <= N; i++) {
            // 오버플로우 방지를 위해 더할 때마다 15746으로 나눈 나머지를 저장
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }
        
        System.out.println(dp[N]);
    }
}