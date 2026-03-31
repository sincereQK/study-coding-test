import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // M 주차장을 한 바퀴 도는 데 걸리는 시간
        int M = Integer.parseInt(br.readLine());
        
        // K 주차장의 온도
        int K = Integer.parseInt(br.readLine());
        
        // C 주차 자리를 찾기 위해 돌아야 하는 횟수
        int C = Integer.parseInt(br.readLine());
        
        // 한 바퀴 도는 시간 * 횟수
        System.out.println(M * C);
    }
}