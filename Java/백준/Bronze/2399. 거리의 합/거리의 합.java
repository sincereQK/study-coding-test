import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        long[] points = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            points[i] = Long.parseLong(st.nextToken());
        }
        
        long totalDistance = 0;
        
        // i < j 인 쌍의 거리만 먼저 모두 더함
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                totalDistance += Math.abs(points[i] - points[j]);
            }
        }
        
        // (i, j) 쌍과 (j, i) 쌍의 거리가 같으므로 마지막에 2를 곱해줌
        System.out.println(totalDistance * 2);
    }
}