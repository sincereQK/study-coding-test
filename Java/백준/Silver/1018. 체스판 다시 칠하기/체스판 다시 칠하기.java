import java.io.*;
import java.util.*;

public class Main {
    
    public static boolean[][] board;
    public static int minRepaint = 64; // 8x8 보드에서 최대로 칠할 수 있는 칸의 수는 64개

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열

        board = new boolean[N][M];

        // 보드 상태 입력
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                if (row.charAt(j) == 'W') {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }

        // 8x8 크기로 자를 수 있는 모든 시작점에 대해 탐색
        int rowLimit = N - 7;
        int colLimit = M - 7;

        for (int i = 0; i < rowLimit; i++) {
            for (int j = 0; j < colLimit; j++) {
                findMinimum(i, j);
            }
        }

        System.out.println(minRepaint);
    }

    public static void findMinimum(int startRow, int startCol) {
        int endRow = startRow + 8;
        int endCol = startCol + 8;
        int count = 0;

        // 현재 8x8 보드의 첫 번째 칸 색상
        boolean expectedColor = board[startRow][startCol];

        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                // 현재 칸의 색이 예상되는 색과 다르면 칠해야 함
                if (board[i][j] != expectedColor) {
                    count++;
                }
                // 다음 칸은 색이 바뀌어야 함 (W -> B, B -> W)
                expectedColor = !expectedColor;
            }
            // 줄이 바뀔 때도 색이 한 번 더 바뀌어야 함
            expectedColor = !expectedColor;
        }

        // 첫 칸 색을 기준으로 한 칠하기 횟수(count)와, 
        // 반대 색 패턴을 기준으로 한 칠하기 횟수(64 - count) 중 최소
        count = Math.min(count, 64 - count);

        // 현재까지 발견된 전체 최솟값과 비교하여 갱신
        minRepaint = Math.min(minRepaint, count);
    }
}