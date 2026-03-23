package Greedy;

import java.io.*;
import java.util.*;

public class BOJ_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int count = 0;

        // A를 B로 바꿈
        // 2를 곱한다.
        // 1을 수의 가장 오른쪽에 추가한다.

        // 2 162
        // 2 → 4 → 8 → 81 → 162

        // 100 40021
        // 100 → 200 → 2001 → 4002 → 40021

        // 4 42
        // -1

        // 언제 2를 곱해야하고 언제 오른쪽에 1을 더해야할까
        // 일단 가장 오른쪽에 0이 아닌 숫자가 있으면 1을 빼는걸로 해보자

        // 가장 오른쪽에 1을 추가하는거다.
        // 자릿수를 구하는 방법은 %를 이용하면 된다.
        // % 10을 하면 1의 자릿수를 구할수있고
        // & 100을 하면 10의 자릿수
        // 그러므로 % 10을 했을때 1이 나오면 1을 가장 오른쪽에 추가한것이 된거
        // 1을 떨어 뜨리는것도 몫을 구하면 됨 -> / 10 으로 구할수있음

        // -1이 나오는 조건을 봐야하는데
        // 42 - 21 - 2 - A보다 작음 - 실패
        // 2로 나누었을때 나머지가 있으면 실패

        while(B > A) {
            if (B % 10 == 1) {
                B = B / 10; // 1을 떨어뜨리기
                count++;
            } else {
                // 2로 나누기를 시도
                if (B % 2 != 0) {
                    count = -1;
                    System.out.println(count);
                    return;
                }
                B = B / 2;
                count++;
            }
        }

        if (B == A) {
            // 무사히 A에 도착했다면 성공! (출제자의 요구대로 +1 해서 출력)
            System.out.println(count + 1);
        } else {
            // A를 지나쳐서 B가 더 작아져 버렸다면 실패!
            System.out.println(-1);
        }

/*
        // 조금 더 다듬어진 답안
        int count = 1; // 문제에서 1을 더해서 출력하라 했으니, 처음부터 1로 시작

        while (B > A) {
            if (B % 10 == 1) {
                B /= 10;
            } else if (B % 2 == 0) {
                B /= 2;
            } else {
                // 끝이 1도 아니고 짝수도 아니면 실패
                System.out.println(-1);
                return; // 메인 함수 즉시 종료
            }
            count++; // 연산을 한 번 할 때마다 횟수 증가
        }

        // 루프를 빠져나왔을 때 무사히 A에 도착했는지 확인
        if (B == A) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
*/
    }
}
