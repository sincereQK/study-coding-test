import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 이 문제는 N이 최대 100,000
        // 100,000 * 100,000은 100억이다.
        // 그러므로 배열을 만들 수가 없다.
        // 임의의 숫자 mid를 골랐을 때, 이 mid보다 작거나 같은 숫자는 배열에 몇 개 있는가?
        // 라는 생각으로 진행
        // 만약 mid보다 작거나 같은 숫자의 개수가 K개 이상이라면, K번째 숫자는 mid 이하에 존재한다는 뜻
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        
        long left = 1;
        long right = K;
        long result = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2; // 정답의 후보가 되는 숫자
            long count = 0; // mid보다 작거나 같은 숫자의 총 개수
            
            // 각 행마다 mid 이하의 숫자가 몇 개 있는지 계산하여 더함
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }
            
            // mid 이하인 숫자의 개수가 K개 이상인 경우
            // 정답 후보에 올리고, 더 작은 숫자 중에서도 조건을 만족하는 게 있는지 탐색 범위를 낮춤
            if (count >= K) {
                result = mid;
                right = mid - 1;
            } 
            // mid 이하인 숫자의 개수가 K개 미만인 경우
            // K번째 숫자가 되기엔 턱없이 부족하므로 탐색 범위를 높임
            else {
                left = mid + 1;
            }
        }
        
        System.out.println(result);
    }
}