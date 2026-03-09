package Bruteforcing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_9663 {

    static int[] board;
    static int count = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N];

        nQueen(0);

        System.out.println(count);
    }

    public static void nQueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[depth] = i;

            if (isSafe(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    public static boolean isSafe(int row) {
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i]) {
                return false;
            }

            if (Math.abs(row - i) == Math.abs(board[row] - board[i])) {
                return false;
            }
        }

        return true;
    }
}