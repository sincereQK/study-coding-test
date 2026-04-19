import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int C = Integer.parseInt(st.nextToken()); // 설치할 공유기의 개수
        
        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);
        
        // 이분 탐색 범위 설정
        int left = 1; 
        int right = houses[N - 1] - houses[0]; 
        int result = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2; // 현재 설정한 최소 인접 거리
            
            // 첫 번째 집에는 무조건 설치한다고 가정
            int installedCount = 1;
            int lastInstalledPos = houses[0];
            
            // 두 번째 집부터 탐색하며 공유기 설치 시도
            for (int i = 1; i < N; i++) {
                // 현재 집과 마지막으로 설치한 집의 거리가 mid 이상이면 설치
                if (houses[i] - lastInstalledPos >= mid) {
                    installedCount++;
                    lastInstalledPos = houses[i]; // 설치 위치 갱신
                }
            }
            
            // 공유기를 목표치 이상 설치할 수 있는 경우
            // 거리를 더 넓혀서 다시 시도해 본다
            if (installedCount >= C) {
                result = mid; // 정답으로 저장
                left = mid + 1;
            } 
            // 공유기를 목표치만큼 설치하지 못한 경우
            // 기준 거리가 너무 넓어서 그런 것이므로 거리를 좁힘
            else {
                right = mid - 1;
            }
        }
        
        System.out.println(result);
    }
}