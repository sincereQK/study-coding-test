package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());

        // 다른 답안.
        sb.setLength(0);

        for(int i = 1; i <= N; i++){
            sb.append("*".repeat(i));
            // sb.append("*".repeat(Math.max(0, i)));
            sb.append("\n");
        }
    }
}
