import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // x좌표
            arr[i][1] = Integer.parseInt(st.nextToken()); // y좌표
        }
        
        // 람다식을 활용한 다중 조건 정렬 (y좌표 우선)
        Arrays.sort(arr, (e1, e2) -> {
            if (e1[1] == e2[1]) {
                // y좌표가 같으면 x좌표를 기준으로 오름차순
                return e1[0] - e2[0];
            } else {
                // y좌표가 다르면 y좌표를 기준으로 오름차순
                return e1[1] - e2[1];
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }

        System.out.print(sb);
    }
}