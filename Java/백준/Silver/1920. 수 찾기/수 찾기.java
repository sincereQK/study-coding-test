import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // 오름차순 정렬
        Arrays.sort(A);
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            
            sb.append(binarySearch(A, target)).append("\n");
        }
        
        System.out.print(sb);
    }
    
    // 이분 탐색
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2; // 중간 인덱스 계산
            
            // 찾은 경우
            if (arr[mid] == target) {
                return 1;
            } 
            // 중간값이 타겟보다 작으면, 타겟은 오른쪽에 있음
            else if (arr[mid] < target) {
                left = mid + 1;
            } 
            // 3. 중간값이 타겟보다 크면, 타겟은 왼쪽에 있음
            else {
                right = mid - 1;
            }
        }
        
        return 0;
    }
}