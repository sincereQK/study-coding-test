package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018 {
    static boolean[][] board; // W = true, B = false

    static int minPaint = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                // W = true, B = false
                if (row.charAt(j) == 'W') {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }
        // 돋보기 이동시키기 (8x8 크기이므로 전체 크기에서 8을 뺀 곳까지만 시작점이 될 수 있음!)
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j < M - 8; j++) {
                findMinPaint(i, j);
            }
        }

        System.out.println(minPaint);
    }


    // 시작점을 주고 해당 점부터 8x8의 보드를 검사하는 함수
    public static void findMinPaint(int startRow, int startCol) {
        int endRow = startRow + 8;
        int endCol = startCol + 8;
        int count = 0;

        // 첫번쨰 칸의 색상, W = true, B = false
        boolean expectedColor = board[startRow][startCol];

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {

                // 현재 위치의 색상이 우리가 원하는 색상과 다르다면 색을 새로 칠해야함
                if (board[i][j] != expectedColor) {
                    count++;
                }

                // 우리가 원하는 색상으로 나왔으면 옆칸으로 이동후 옆칸의 색상은 현재 칸의 색상과 반대, 그러므로 바꿔줨
                expectedColor = !expectedColor;
            }
            // 줄이 바뀔때도 색상을 바꿔줘야하므로 변경
            expectedColor = !expectedColor;

        }

        // 첫 칸 기준으로 칠할 개수(count)와, 반대 패턴으로 칠할 개수(64 - count) 중 더 작은 것 선택
        count = Math.min(count, 64 - count);

        // 역대 최솟값과 비교해서 더 작다면 갱신! (우리가 배운 Math.min 사용)
        minPaint = Math.min(minPaint, count);

    }

}
