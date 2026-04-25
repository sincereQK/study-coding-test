import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int year = 1;
        
        // 정답을 찾을 때까지 연도를 1씩 증가시키며 탐색
        while (true) {
            // (year - E)가 각각의 최대 주기로 나누어 떨어지는지 확인
            if ((year - E) % 15 == 0 && (year - S) % 28 == 0 && (year - M) % 19 == 0) {
                break; // 세 주기가 모두 딱 맞아떨어지는 순간 성공
            }
            year++;
        }
        
        System.out.println(year);
    }
}