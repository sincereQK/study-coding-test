package Bruteforcing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_14888 {

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    static int[] numbers; // 주어진 숫자들을 담을 배열
    static int[] operators = new int[4]; // +, -, *, / 카드의 개수를 담을 배열 (크기 4)
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numbers[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int currentResult, int idx) {

        if (idx == N) {
            MAX = Math.max(MAX, currentResult);
            MIN = Math.min(MIN, currentResult);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {

                operators[i]--;

                switch (i) {
                    case 0: dfs(currentResult + numbers[idx], idx + 1); break;
                    case 1: dfs(currentResult - numbers[idx], idx + 1); break;
                    case 2: dfs(currentResult * numbers[idx], idx + 1); break;
                    case 3: dfs(currentResult / numbers[idx], idx + 1); break;
                }
                
                operators[i]++;
            }
        }
    }
}