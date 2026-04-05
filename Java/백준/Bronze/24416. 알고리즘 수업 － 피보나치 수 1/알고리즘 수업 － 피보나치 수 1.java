import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        // DP를 위한 배열 생성
        int[] f = new int[n + 1];
        
        // 피보나치 수 기본값 설정
        f[1] = 1;
        f[2] = 1;
        
        // DP 방식으로 피보나치 수 계산
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        
        // 재귀 호출 코드의 실행 횟수 = 피보나치 수 n의 값
        int count1 = f[n];
        
        // DP 코드의 실행 횟수 = for 루프 반복 횟수 (n - 2)
        int count2 = n - 2;

        System.out.println(count1 + " " + count2);
    }
}