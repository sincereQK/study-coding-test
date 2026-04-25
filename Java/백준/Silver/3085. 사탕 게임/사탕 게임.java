import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] board;
    static int maxCount = 1; // 최소 사탕 1개는 먹음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 가로로 인접한 두 사탕 교환하며 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1); // 상태 변경
                check();              // 최댓값 검증
                swap(i, j, i, j + 1); // 복구
            }
        }

        // 세로로 인접한 두 사탕 교환하며 탐색
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i + 1, j); // 상태 변경
                check();              // 최댓값 검증
                swap(i, j, i + 1, j); // 복구
            }
        }

        System.out.println(maxCount);
    }

    // 두 사탕 위치 바꾸기
    static void swap(int r1, int c1, int r2, int c2) {
        char temp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = temp;
    }

    // 보드 전체를 스캔, 가장 긴 연속 사탕 길이를 찾기
    static void check() {
        // 가로 스캔
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1; // 색이 달라지면 카운트 초기화
                }
            }
            // 끝까지 연속된 경우를 대비해 한 번 더 갱신
            maxCount = Math.max(maxCount, count);
        }

        // 세로 스캔
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
    }
}