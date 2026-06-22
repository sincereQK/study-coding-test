import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] prefix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        prefix = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int v = Integer.parseInt(st.nextToken());
                prefix[i][j] = v + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }

        List<int[]> rects = new ArrayList<>();
        for (int r1 = 1; r1 <= N; r1++)
            for (int c1 = 1; c1 <= M; c1++)
                for (int r2 = r1; r2 <= N; r2++)
                    for (int c2 = c1; c2 <= M; c2++)
                        rects.add(new int[]{r1, c1, r2, c2});

        long answer = Long.MIN_VALUE;
        int K = rects.size();
        for (int i = 0; i < K; i++) {
            for (int j = i + 1; j < K; j++) {   // 서로 다른 두 직사각형
                if (!overlap(rects.get(i), rects.get(j))) {
                    long sum = rectSum(rects.get(i)) + rectSum(rects.get(j));
                    answer = Math.max(answer, sum);
                }
            }
        }
        System.out.println(answer);
    }

    static long rectSum(int[] R) {
        int r1 = R[0], c1 = R[1], r2 = R[2], c2 = R[3];
        return prefix[r2][c2] - prefix[r1-1][c2] - prefix[r2][c1-1] + prefix[r1-1][c1-1];
    }

    // 두 직사각형이 겹치는가
    static boolean overlap(int[] A, int[] B) {
        // 안 겹치는 조건: 한 축에서 완전히 분리
        if (A[2] < B[0] || B[2] < A[0]) return false;  // 행으로 분리
        if (A[3] < B[1] || B[3] < A[1]) return false;  // 열로 분리
        return true;                                    // 그 외엔 겹침
    }
}