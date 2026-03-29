import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        // 밥알이 320개인 조건 - 점심시간(12시~16시) 이면서 술을 안 마실 때(S == 0)
        if (T >= 12 && T <= 16 && S == 0) {
            System.out.println(320);
        } else {
            // 그 외
            System.out.println(280);
        }
    }
}