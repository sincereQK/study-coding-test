import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        
        // x와 y의 범위인 -999부터 999까지 완전 탐색
        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                
                // 두 방정식을 동시에 만족하는 x, y를 찾으면 출력
                if ((a * x + b * y == c) && (d * x + e * y == f)) {
                    System.out.println(x + " " + y);
                    return;
                }
                
            }
        }
    }
}