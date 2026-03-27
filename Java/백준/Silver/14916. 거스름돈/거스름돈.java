import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int count = 0;
        
        while (n > 0) {
            // 현재 남은 금액이 5로 나누어 떨어지면, 5원짜리로 다 거슬러 줌
            if (n % 5 == 0) {
                count += n / 5;
                n = 0; // 거스름돈을 다 주었으므로 0
                break;
            }
            
            // 2. 5로 나누어 떨어지지 않으면, 2원을 하나 사용
            n -= 2;
            count++;
        }
        
        // 거스름돈을 정확히 줄 수 없는 경우 -1
        if (n < 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}