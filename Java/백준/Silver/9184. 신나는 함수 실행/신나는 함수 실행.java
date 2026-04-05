import java.io.*;
import java.util.*;

public class Main {
    
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 종료 조건
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a, b, c)).append("\n");
        }

        System.out.print(sb);
    }

    static int w(int a, int b, int c) {
        // 배열 범위를 벗어나는 음수 또는 0 검사
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        // 20을 초과하는 경우 검사
        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = w(20, 20, 20);
        }

        // 이미 계산해둔 값이 있다면 (0이 아니라면) 바로 반환 (핵심!)
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        // 계산된 값이 없다면 문제의 공식대로 계산 후 dp 배열에 저장하고 반환
        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}