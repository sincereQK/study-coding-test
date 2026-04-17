import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        int[] trees = new int[N];
        int maxTreeHeight = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            // 입력과 동시에 가장 높은 나무 찾기
            if (trees[i] > maxTreeHeight) {
                maxTreeHeight = trees[i];
            }
        }
        
        // 이분 탐색 범위 설정
        long left = 0;
        long right = maxTreeHeight;
        long result = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2; // 현재 설정한 절단기의 높이
            long sum = 0; // 잘린 나무들의 길이 합
            
            for (int tree : trees) {
                // 나무가 절단기 높이보다 클 때만 자름
                if (tree > mid) {
                    sum += (tree - mid);
                }
            }
            
            // 자른 나무의 합이 필요한 양(M)보다 많거나 같은 경우
            if (sum >= M) {
                result = mid;    // 조건을 만족하므로 일단 정답 후보로 기록
                left = mid + 1;  // 절단기 높이를 더 높여서 최댓값을 찾아봄
            } 
            // 2. 자른 나무의 합이 필요한 양보다 적은 경우
            else {
                right = mid - 1; // 절단기 높이를 낮춰서 나무를 더 많이 자름
            }
        }
        
        System.out.println(result);
    }
}