import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] la, lb;
    static int[] target;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        la = new int[M];
        lb = new int[M];
        boolean[] all = new boolean[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            la[i] = Integer.parseInt(st.nextToken());
            lb[i] = Integer.parseInt(st.nextToken());
            all[i] = true;
        }

        target = simulate(all);
        answer = M;

        backtrack(0, new boolean[M], 0);
        System.out.println(answer);
    }

    static void backtrack(int idx, boolean[] used, int cnt) {
        if (cnt >= answer) return;

        if (idx == M) {
            if (Arrays.equals(simulate(used), target)) {
                answer = Math.min(answer, cnt);
            }
            return;
        }

        used[idx] = true;
        backtrack(idx + 1, used, cnt + 1);
        used[idx] = false;

        backtrack(idx + 1, used, cnt);
    }

    static int[] simulate(boolean[] used) {
        int[] pos = new int[N];
        for (int i = 0; i < N; i++) pos[i] = i;

        Integer[] order = new Integer[M];
        for (int i = 0; i < M; i++) order[i] = i;
        Arrays.sort(order, (x, y) -> lb[x] - lb[y]);

        for (int k : order) {
            if (!used[k]) continue;
            int col = la[k] - 1;
            for (int i = 0; i < N; i++) {
                if (pos[i] == col) pos[i] = col + 1;
                else if (pos[i] == col + 1) pos[i] = col;
            }
        }
        return pos;
    }
}