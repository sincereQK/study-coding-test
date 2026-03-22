package Greedy;

import java.util.*;
import java.io.*;

public class BOJ_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for(int i = N -1; i >= 0; i--) {
            if(coins[i] <= K){
                count += (K / coins[i]); // 몫, 사용한 동전 갯수
                K = K % coins[i]; // 계산 후 남은 금액
            }
        }

        System.out.println(count);

    }
}
