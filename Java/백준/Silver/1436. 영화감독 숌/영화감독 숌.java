import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int number = 666; // 가장 작은 종말의 숫자
        int count = 1;    // 종말의 숫자를 찾은 횟수 (666이 1번째)
        
        // N이 1일 때는 바로 666 출력 후 종료되도록 조건문 설정
        while (count != N) {
            number++; // 숫자를 1씩 무조건 증가
            
            // 숫자를 문자열로 변환하여 "666"이 포함되어 있는지 확인
            if (String.valueOf(number).contains("666")) {
                count++; // 포함되어 있다면 카운트 증가
            }
        }
        
        System.out.println(number);
    }
}