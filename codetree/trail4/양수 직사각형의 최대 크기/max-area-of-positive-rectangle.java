import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] pos = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int v = Integer.parseInt(st.nextToken());
                int p = (v > 0) ? 1 : 0;
                pos[i][j] = p + pos[i-1][j] + pos[i][j-1] - pos[i-1][j-1];
            }
        }

        int answer = -1;
        for (int r1 = 1; r1 <= N; r1++) {
            for (int c1 = 1; c1 <= M; c1++) {
                for (int r2 = r1; r2 <= N; r2++) {
                    for (int c2 = c1; c2 <= M; c2++) {
                        int area = (r2 - r1 + 1) * (c2 - c1 + 1);
                        int posCount = pos[r2][c2] - pos[r1-1][c2] - pos[r2][c1-1] + pos[r1-1][c1-1];
                        if (posCount == area) {
                            answer = Math.max(answer, area);
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}