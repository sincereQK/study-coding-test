import java.util.Scanner;

public class Main {
    static int N;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        backtrack(0);
        System.out.println(count);
    }

    static void backtrack(int filled) {
        if (filled == N) {
            count++;
            return;
        }
        for (int d = 1; d <= 4; d++) {
            if (filled + d > N) continue;
            backtrack(filled + d);
        }
    }
}