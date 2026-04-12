import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        long[] arr = new long[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        long maxLoss = 0;
        
        // 기구의 개수가 짝수
        if (N % 2 == 0) {
            for (int i = 0; i < N / 2; i++) {
                // 양 끝에서부터 짝지어 합을 구하고 최댓값 확인
                long currentSum = arr[i] + arr[N - 1 - i];
                maxLoss = Math.max(maxLoss, currentSum);
            }
        } 
        // 기구의 개수가 홀수
        else {
            // 가장 큰 값은 혼자 사용하므로 미리 최댓값 설정
            maxLoss = arr[N - 1];
            // 가장 큰 값을 제외한 나머지(N-1개, 짝수 개)를 양 끝에서부터 짝지음
            for (int i = 0; i < (N - 1) / 2; i++) {
                long currentSum = arr[i] + arr[N - 2 - i];
                maxLoss = Math.max(maxLoss, currentSum);
            }
        }
        
        System.out.println(maxLoss);
    }
}