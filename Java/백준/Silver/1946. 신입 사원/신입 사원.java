import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            int N = Integer.parseInt(br.readLine());

            int[] applicant = new int[N + 1];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int resume = Integer.parseInt(st.nextToken());    // 서류 등수
                int interview = Integer.parseInt(st.nextToken()); // 면접 등수

                // 서류 등수를 방 번호로, 면접 등수를 값으로 저장!
                // 이렇게 하면 applicant[1] 에는 서류 1등의 면접 등수가 들어갑니다.
                applicant[resume] = interview;

            }

            int count = 1; // 서류 1등은 무조건 합격임

            // 현재까지 합격한 사람들 중 가장 좋은 면접등수를 기록
            // 초기값으나 서류 1등의 면접 등수
            int minInterviewRank = applicant[1];

            // 서류 2등부터 N등까지 차례대로 면접 등수를 검사
            for (int i = 2; i <= N; i++) {
                // 지금 검사하는 사람의 면접 등수가 지금까지 본 최고 면접 등수(minInterviewRank)보다 숫자가 작다면(좋다면)?
                if (applicant[i] < minInterviewRank) {
                    count++; // 합격이므로 count 증가
                    minInterviewRank = applicant[i]; // 그리고 이사람의 등수가 새로운 최고등수 이므로 새로 갱신
                }
            }

            System.out.println(count);

        } // 다음 T로 이동

    }
}
