package Bruteforcing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_14501 {

    static int N;
    static int[] T;
    static int[] P;
    static int maxProfit = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        T = new int[N];
        P = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(maxProfit);
    }

    public static void dfs(int day, int currentProfit) {
        if (day >= N) {
            maxProfit = Math.max(maxProfit, currentProfit);
            return;
        }

        if (day + T[day] <= N) {
            dfs(day + T[day], currentProfit + P[day]);
        }

        dfs(day + 1, currentProfit);
    }
}