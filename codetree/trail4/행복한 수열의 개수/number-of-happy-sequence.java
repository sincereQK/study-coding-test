import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (isHappyRow(i)) count++;
            if (isHappyCol(i)) count++;
        }
        System.out.println(count);
    }

    static boolean check(int[] seq) {
        int run = 1;
        for (int k = 1; k < seq.length; k++) {
            if (seq[k] == seq[k - 1]) run++;
            else run = 1;
            if (run >= M) return true;
        }
        return M == 1;
    }

    static boolean isHappyRow(int r) {
        int[] seq = new int[N];
        for (int j = 0; j < N; j++) seq[j] = grid[r][j];
        return check(seq);
    }

    static boolean isHappyCol(int c) {
        int[] seq = new int[N];
        for (int i = 0; i < N; i++) seq[i] = grid[i][c];
        return check(seq);
    }
}