import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 아파트 거주민 수를 미리 계산해둘 2차원 배열 생성
        int[][] apt = new int[15][15];
        
        for (int i = 0; i < 15; i++) {
            apt[i][1] = 1; // 각 층의 1호는 무조건 1명
            apt[0][i] = i; // 0층의 i호는 i명
        }
        
        // 나머지 호수 인원 채우기
        for (int i = 1; i < 15; i++) {       // 1층부터 14층까지
            for (int j = 2; j < 15; j++) {   // 2호부터 14호까지
                // 현재 호수 인원 = 같은 층 옆집 인원 + 아래층 같은 호수 인원
                apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
            }
        }
        
        // 테스트 케이스 처리
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호
            
            sb.append(apt[k][n]).append("\n");
        }
        
        System.out.print(sb);
    }
}