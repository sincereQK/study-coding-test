import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] g;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        g = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                g[i][j] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        // 시작점 (r,c)
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // 변 길이 a(방향1·3), b(방향2·4), 각각 1 이상
                for (int a = 1; a < N; a++) {
                    for (int b = 1; b < N; b++) {
                        int sum = traverse(r, c, a, b);
                        if (sum >= 0) answer = Math.max(answer, sum);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    // (r,c)에서 시작해 방향1 a칸 → 방향2 b칸 → 방향3 a칸 → 방향4 b칸 둘레를 돈다
    // 격자를 벗어나면 -1, 아니면 둘레 칸들의 합 반환
    static int traverse(int r, int c, int a, int b) {
        // 방향: 1=↗(-1,+1), 2=↖(-1,-1), 3=↙(+1,-1), 4=↘(+1,+1)
        int[] dr = {-1, -1, +1, +1};
        int[] dc = {+1, -1, -1, +1};
        int[] steps = {a, b, a, b};   // 각 방향 이동 칸 수

        int sum = 0;
        int cr = r, cc = c;
        for (int d = 0; d < 4; d++) {
            for (int s = 0; s < steps[d]; s++) {
                cr += dr[d];
                cc += dc[d];
                if (cr < 0 || cr >= N || cc < 0 || cc >= N) return -1;  // 격자 이탈
                sum += g[cr][cc];
            }
        }
        // 시작점으로 정확히 돌아왔는지 확인 (닫힌 도형)
        if (cr == r && cc == c) return sum;
        return -1;
    }
}