import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        
        // 특정 1시간 단위(i ~ i+1)에 가능한 사람 수를 저장할 배열
        int[] time = new int[1001];
        int maxEndTime = 0; // 입력받은 끝나는 시간 중 가장 늦은 시간 기록
        
        // 모든 참가자의 가능 시간 누적하기
        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(br.readLine());
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                
                maxEndTime = Math.max(maxEndTime, E);
                
                // S부터 E-1까지 1시간 단위로 사람 수 누적
                for (int t = S; t < E; t++) {
                    time[t]++;
                }
            }
        }
        
        // 슬라이딩 윈도우를 활용하여 T시간 동안의 최대 만족도 찾기
        int maxSum = 0;
        int currentSum = 0;
        int bestStart = 0;
        
        // 초기 윈도우(0시부터 T시간 동안)의 합 계산
        for (int i = 0; i < T; i++) {
            currentSum += time[i];
        }
        maxSum = currentSum;
        bestStart = 0;
        
        // 윈도우를 한 칸씩 오른쪽으로 밀면서 합을 갱신
        for (int i = 1; i <= maxEndTime - T; i++) {
            // 한 칸 밀렸으므로, 새로 들어온 시간의 값을 더하고 빠져나간 시간의 값을 뺌
            currentSum = currentSum + time[i + T - 1] - time[i - 1];
            
            // 만족도가 이전 최대치보다 클 때만 갱신 (시작 시간이 빠른 것을 우선하기 위함)
            if (currentSum > maxSum) {
                maxSum = currentSum;
                bestStart = i;
            }
        }
        
        System.out.println(bestStart + " " + (bestStart + T));
    }
}