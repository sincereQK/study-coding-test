package Greedy;

import java.util.*;
import java.io.*;

public class BOJ_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        // 정확하게 N 킬로 그램을 만들수 없으면 -1
        // N = 5 * x + 3 * y
        // 3 ≤ N ≤ 5000

        // 남은 무게가 3보다 작음(2,1) -> 계속해서 무게 3 봉지로 뺴내다가 완벽하게 분류가 불가능해지는 때가
        while (N >= 3) {
            if (N % 5 == 0) {
                count += N / 5;
                N = 0;
                break;
            } else {
                N -= 3;
                count++;
            }
        }
        // 더 좋은 해답
/*
        // N이 0 이상일 때까지만 반복 (음수가 되면 3, 5로 딱 떨어지게 나눌 수 없다는 뜻)
        while (N >= 0) {

            // 1. 현재 남은 설탕이 5의 배수라면? (제일 베스트 상황!)
            if (N % 5 == 0) {
                count += N / 5;          // 5kg 봉지 개수만큼 싹 다 더하고
                System.out.println(count); // 정답 출력!
                return;                    // ⭐ 정답을 찾았으니 메인 함수 자체를 여기서 즉시 종료!
            }

            // 2. 5의 배수가 아니라면? 어쩔 수 없이 3kg 봉지에 하나 담고 다시 확인
            N -= 3;
            count++;
        }

        // 3. while문을 다 돌았는데도 return으로 탈출하지 못하고 여기까지 왔다면?
        // 3씩 아무리 빼도 5의 배수를 못 찾고 N이 음수가 되어버린 '실패' 상황입니다.
        System.out.println(-1);
*/
    }
}
