package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 바구니 초기화 (1~N번)
        int[] baskets = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            baskets[i] = i;
        }

        // 2. M번 뒤집기 수행
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            // 구간 i부터 j까지 뒤집기
            while (i < j) {
                int temp = baskets[i];
                baskets[i] = baskets[j];
                baskets[j] = temp;
                i++; // 왼쪽 인덱스는 증가
                j--; // 오른쪽 인덱스는 감소
            }
        }

        // 3. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(baskets[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}