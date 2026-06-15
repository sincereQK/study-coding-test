import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] board;
    static List<int[]> bombs = new ArrayList<>();
    static int answer = 0;

    // 모양별 상대좌표
    static int[][][] shapes = {
        // 세로 5칸
        {{-2,0},{-1,0},{0,0},{1,0},{2,0}},
        // 십자
        {{0,0},{-1,0},{1,0},{0,-1},{0,1}},
        // X자
        {{0,0},{-1,-1},{-1,1},{1,-1},{1,1}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) bombs.add(new int[]{i, j});
            }
        }
        backtrack(0, new int[bombs.size()]);
        System.out.println(answer);
    }

    static void backtrack(int depth, int[] choice) {
        if (depth == bombs.size()) {
            answer = Math.max(answer, countBurned(choice));
            return;
        }
        for (int s = 0; s < 3; s++) {
            choice[depth] = s;
            backtrack(depth + 1, choice);
        }
    }

    static int countBurned(int[] choice) {
        boolean[][] burned = new boolean[N][N];
        for (int b = 0; b < bombs.size(); b++) {
            int r = bombs.get(b)[0], c = bombs.get(b)[1];
            for (int[] d : shapes[choice[b]]) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    burned[nr][nc] = true;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (burned[i][j]) cnt++;
        return cnt;
    }
}