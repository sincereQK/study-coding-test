import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] val, dir;
    static int[][] memo;

    static int[] dr = {0, -1, -1,  0,  1,  1,  1,  0, -1};
    static int[] dc = {0,  0,  1,  1,  1,  0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        val = new int[N][N];
        dir = new int[N][N];
        memo = new int[N][N];
        for (int[] row : memo) Arrays.fill(row, -1);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) val[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) dir[i][j] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(dfs(r, c));
    }

    static int dfs(int r, int c) {
        if (memo[r][c] != -1) return memo[r][c];
        int d = dir[r][c];
        int best = 0;
        int nr = r + dr[d], nc = c + dc[d];
        while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
            if (val[nr][nc] > val[r][c]) {
                best = Math.max(best, 1 + dfs(nr, nc));
            }
            nr += dr[d];
            nc += dc[d];
        }
        memo[r][c] = best;
        return best;
    }
}