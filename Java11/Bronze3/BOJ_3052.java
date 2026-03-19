package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 42로 나눈 나머지는 0~41까지 나올 수 있음
        boolean[] remainders = new boolean[42];
        int count = 0;

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            // 나머지 값을 인덱스로 사용하여 true 체크
            remainders[num % 42] = true;
        }

        // true인 개수 세기
        for (boolean r : remainders) {
            if (r) {
                count++;
            }
        }

        System.out.println(count);
    }
}