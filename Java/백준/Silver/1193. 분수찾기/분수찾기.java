import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int X = Integer.parseInt(br.readLine());
        
        int crossCount = 1;
        int prevCountSum = 0;
        
        while (true) {
            // X가 현재 대각선 범위 안에 포함되는지 확인
            if (X <= prevCountSum + crossCount) {
                // 현재 대각선 안에서 몇 번째 위치인지 파악
                int k = X - prevCountSum; 
                
                if (crossCount % 2 == 1) {
                    // 대각선이 홀수 번째인 경우
                    // 분자는 감소, 분모는 증가
                    System.out.println((crossCount - k + 1) + "/" + k);
                } else {
                    // 대각선이 짝수 번째인 경우
                    // 분자는 증가, 분모는 감소
                    System.out.println(k + "/" + (crossCount - k + 1));
                }
                break;
                
            } else {
                // 현재 대각선에 포함되지 않으면, 누적 개수를 더하고 다음 대각선으로 넘어감
                prevCountSum += crossCount;
                crossCount++;
            }
        }
    }
}