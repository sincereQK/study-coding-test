import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // 병사들의 선호도 A, B, C 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 후라이드
        int B = Integer.parseInt(st.nextToken()); // 양념
        int C = Integer.parseInt(st.nextToken()); // 간장
        
        // 각 종류별로 받을 수 있는 최대 인원을 구해서 합산
        int total = Math.min(N, A) + Math.min(N, B) + Math.min(N, C);
        
        System.out.println(total);
    }
}