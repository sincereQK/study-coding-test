package DynamicProgramming;

import java.io.*;

public class BOJ_1463 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 1. 수첩(배열) 준비하기
        // dp[i]는 숫자 i를 1로 만드는 데 걸리는 "최소 연산 횟수"를 적어두는 공간입니다.
        int[] dp = new int[N + 1];

        // 2. 2부터 N까지 차례대로 수첩을 채워 나갑니다. (1은 이미 1이므로 0번 연산 필요)
        for (int i = 2; i <= N; i++) {

            // 방법 A: 일단 1을 빼는 경우를 기본값으로 깔고 갑니다.
            // i-1을 1로 만들었던 최소 횟수 수첩(dp[i-1])을 들여다보고, 거기에 1번(+1)을 추가합니다.
            dp[i] = dp[i - 1] + 1;

            // 방법 B: 만약 2로 나누어 떨어진다면?
            if (i % 2 == 0) {
                // 방금 구한 1을 뺀 횟수(dp[i])와, i/2를 1로 만들었던 횟수(dp[i/2]) + 1번 중 더 작은 것을 수첩에 덮어씁니다!
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 방법 C: 만약 3으로 나누어 떨어진다면?
            if (i % 3 == 0) {
                // 현재까지 기록된 횟수와, i/3을 1로 만들었던 횟수(dp[i/3]) + 1번 중 더 작은 것을 덮어씁니다!
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

        }

        // 3. 수첩에서 N의 최소 횟수를 찾아 출력!
        System.out.println(dp[N]);

    }
}
// 이문제가 그리디 문제인줄 알고 접근했으나
// DP 문제였음을 알게되었다.

/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while(true){
            if(N == 2) {                // 1을 뺀다.
                N = N - 1;
                count++;
                break;
            } else if( N % 2 == 0 ) {   // 3으로 나누어 떨어지면, 3으로 나눈다.
                N = N / 2;
                count++;
            } else if (N % 3 == 0) {    // 2로 나누어 떨어지면, 2로 나눈다.
                N = N/3;
                count++;
            }
        }*/
