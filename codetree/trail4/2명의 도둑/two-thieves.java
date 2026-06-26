import java.util.*;
import java.io.*;

public class Main {
    static int N, M, C;
    static int[][] grid;
    static int bestPick;   // 한 영역 내 백트래킹 결과

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }

        int cols = N - M + 1;             // 시작열 후보 개수
        // best[r][s] = 행 r, 시작열 s인 M칸 영역의 최대 가치 (무게합 ≤ C)
        int[][] best = new int[N][cols];
        for (int r = 0; r < N; r++) {
            for (int s = 0; s < cols; s++) {
                bestPick = 0;
                // 그 M칸에서 부분집합 백트래킹
                backtrack(r, s, 0, 0, 0);
                best[r][s] = bestPick;
            }
        }

        // 두 도둑 영역 조합 완전탐색
        int answer = 0;
        // 영역을 (r, s)로 나열
        for (int r1 = 0; r1 < N; r1++) {
            for (int s1 = 0; s1 < cols; s1++) {
                for (int r2 = 0; r2 < N; r2++) {
                    for (int s2 = 0; s2 < cols; s2++) {
                        if (!overlap(r1, s1, r2, s2)) {
                            answer = Math.max(answer, best[r1][s1] + best[r2][s2]);
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }

    // 행 r, 시작열 s인 M칸 중 idx번째 칸을 고를지/말지
    // curW: 현재 무게합, curV: 현재 가치합
    static void backtrack(int r, int s, int idx, int curW, int curV) {
        if (idx == M) {
            bestPick = Math.max(bestPick, curV);
            return;
        }
        int w = grid[r][s + idx];          // idx번째 칸의 무게
        // 선택지 1: 이 물건을 고른다 (무게 초과 안 할 때만)
        if (curW + w <= C) {
            backtrack(r, s, idx + 1, curW + w, curV + w * w);
        }
        // 선택지 2: 이 물건을 안 고른다
        backtrack(r, s, idx + 1, curW, curV);
    }

    // 두 영역이 겹치는가? (같은 행에서 열 구간이 겹칠 때만 true)
    static boolean overlap(int r1, int s1, int r2, int s2) {
        if (r1 != r2) return false;        // 다른 행이면 안 겹침
        // 같은 행: 구간 [s1, s1+M-1] vs [s2, s2+M-1]
        int e1 = s1 + M - 1, e2 = s2 + M - 1;
        if (e1 < s2 || e2 < s1) return false;  // 완전 분리
        return true;
    }
}