package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;     // 최댓값을 저장할 변수
        int index = 0;   // 위치를 저장할 변수

        for (int i = 1; i <= 9; i++) {
            // 한 줄씩 읽어서 정수로 변환
            int val = Integer.parseInt(br.readLine());

            if (val > max) {
                max = val;
                index = i;
            }
        }

        // 결과 출력
        System.out.println(max);
        System.out.println(index);
    }
}