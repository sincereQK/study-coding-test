import java.util.*;
import java.io.*;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        board = new char[N][N];
        
        // 도화지 전체를 일단 공백으로 깨끗하게 칠해둡니다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = ' ';
            }
        }
        
        makeStar(0, 0, N);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(board[i]);
            sb.append('\n');
        }
        
        System.out.print(sb);
    }

    // 별을 그리는 재귀 함수
    static void makeStar(int r, int c, int size) {
        // 크기가 1x1 단위로 쪼개졌다면, 그 위치에 별을 찍는다.
        if (size == 1) {
            board[r][c] = '*';
            return;
        }
        
        // 블록을 9등분 했을 때, 하나의 작은 블록 크기
        int newSize = size / 3;
        
        // 3x3 구역을 순회하며 재귀 호출
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 정중앙 구역은 비워두어야 하므로 패스
                if (i == 1 && j == 1) {
                    continue;
                }
                
                // 각 작은 블록의 시작 좌표를 계산하여 다음 재귀로 넘김
                makeStar(r + (i * newSize), c + (j * newSize), newSize);
            }
        }
    }
}