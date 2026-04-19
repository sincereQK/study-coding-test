import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 물이 새는 곳의 개수
        int L = Integer.parseInt(st.nextToken()); // 테이프의 길이
        
        int[] leaks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            leaks[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(leaks);
        
        int tapeCount = 0; // 사용한 테이프의 개수
        int coveredUntil = 0; // 현재 테이프가 커버하고 있는 마지막 정수 위치
        
        // 정렬된 파이프의 구멍들을 왼쪽부터 하나씩 살펴봅니다
        for (int i = 0; i < N; i++) {
            // 현재 구멍의 위치가 테이프가 덮고 있는 범위를 벗어났다면
            if (leaks[i] > coveredUntil) {
                tapeCount++; // 새로운 테이프를 하나 뜯어서 붙인다
                
                // 테이프는 좌우 0.5의 간격이 필요하므로, 
                // 구멍 위치 leaks[i]에 붙였을 때 정수 기준으로는 (leaks[i] + L - 1)까지 덮을 수 있다
                coveredUntil = leaks[i] + L - 1;
            }
        }
        
        System.out.println(tapeCount);
    }
}