import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] seg;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        seg = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            seg[i][0] = Integer.parseInt(st.nextToken());
            seg[i][1] = Integer.parseInt(st.nextToken());
        }
        backtrack(0, new ArrayList<>());
        System.out.println(answer);
    }

    static void backtrack(int idx, List<int[]> chosen) {
        if (idx == N) {
            answer = Math.max(answer, chosen.size());
            return;
        }

        if (canPick(seg[idx], chosen)) {
            chosen.add(seg[idx]);
            backtrack(idx + 1, chosen);
            chosen.remove(chosen.size()-1);
        }

        backtrack(idx + 1, chosen);
    }

    static boolean canPick(int[] cand, List<int[]> chosen) {
        for (int[] s : chosen) {
            boolean disjoint = (cand[1] < s[0]) || (s[1] < cand[0]);
            if (!disjoint) return false;
        }
        return true;
    }
}