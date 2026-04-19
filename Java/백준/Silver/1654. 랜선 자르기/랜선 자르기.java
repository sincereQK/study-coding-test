import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
        
        int[] cables = new int[K];
        long max = 0;
        
        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            if (max < cables[i]) {
                max = cables[i]; // 가장 긴 랜선 길이 찾기
            }
        }
        
        // 이분 탐색 범위 설정
        // 랜선의 길이는 0이 될 수 없으므로 left는 1부터 시작
        long left = 1;
        long right = max;
        long result = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2; // 현재 설정한 자르기 기준 길이
            long count = 0; // 잘라낸 랜선의 총 개수
            
            // 모든 랜선을 순회하며 mid 길이로 잘랐을 때 몇 개가 나오는지 계산
            for (int cable : cables) {
                count += (cable / mid);
            }
            
            // 필요한 개수보다 많거나 같게 잘린 경우
            if (count >= N) {
                result = mid;   // 조건을 만족하므로 후보로 기록
                left = mid + 1; // 길이를 더 늘려서 개수를 줄여보고 테스트
            } 
            // 필요한 개수보다 적게 잘린 경우
            else {
                right = mid - 1; // 길이를 줄여서 개수를 늘려야 함
            }
        }

        System.out.println(result);
    }
}