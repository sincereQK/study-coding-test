package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 30명의 학생 출석부 생성 (0번 인덱스는 사용 안 함)
        boolean[] submitted = new boolean[31];

        // 2. 28명의 제출자 번호를 입력받아 체크
        for (int i = 0; i < 28; i++) {
            int studentNum = Integer.parseInt(br.readLine());
            submitted[studentNum] = true;
        }

        // 3. 1번부터 30번까지 확인하며 제출 안 한 사람(false) 출력
        for (int i = 1; i <= 30; i++) {
            if (!submitted[i]) {
                System.out.println(i);
            }
        }
    }
}