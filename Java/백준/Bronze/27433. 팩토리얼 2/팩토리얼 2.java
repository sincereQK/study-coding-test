import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        System.out.println(factorial(N));
    }

    // 재귀를 이용한 팩토리얼 함수
    public static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        
        return n * factorial(n - 1);
    }
}