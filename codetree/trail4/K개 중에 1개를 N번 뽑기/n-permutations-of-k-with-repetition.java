import java.util.Scanner;

public class Main {
    static int K, N;
    static int[] pick;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();
        pick = new int[N];
        backtrack(0);
        System.out.print(sb);
    }

    static void backtrack(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                sb.append(pick[i]);
                if (i < N - 1) sb.append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int num = 1; num <= K; num++) {    // 1~K 오름차순
            pick[depth] = num;
            backtrack(depth + 1);
        }
    }
}