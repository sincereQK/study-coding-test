package Greedy;

import java.io.*;
import java.util.*;

public class BOJ_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // S의 범위가 겁나큼
        long S = Long.parseLong(br.readLine());

        int N = 0;
        // 서로 다른 N개의 자연수의 합이 S
        // N의 최대값을 구하라
        // 19개의 자연수의 합이 200
        // 200 = 1+2+3+4+5+6+7+8+9+10+11+12+13+14+15+16+17+18+19(?)
        // 근데 1부터 19는 합이 190인데?
        // 이러면 최대 갯수니까 적은수부터 차례대로 뺴다가 남은수가 직전에 뺀 수보다 작으면?
        // 거기까지 구하면 될것 같은데?
        // 근데 계속 빼야하잖아? 그럼 일단 범위를 모르니 for문은 못쓰고
        // while문 조건을 어떻게 써야할까?
        // currentNum이라는 조건을 두고 이게 계속 뺴는 S보다 커지면 끝내는걸로 하자.

        int currentNum = 1;
        while(S >= currentNum) {
            S -= currentNum;
            // N의 조건에 대해서 고민해보자.
            // S가 10이면
            // 1+2 / 3+3 / 6 + 4 / 10
            // 이건 너무 깔끔히 떨어지네 다른걸로
            // S가 16 이면
            // 16 -1 / 15 - 2 / 13 - 3 / 10 - 4 / 6 - 5 / 1 -> 여기서 S >= currentNum에 문제가  생김
            // 16 -1 / 15 - 2 / 13 - 3 / 10 - 4 / 6 - 6 / 0 이 되여야함
            // 근데 어차피 N의 갯수만 구하면 되잖아 빠지는 숫자를 구할필요는 없음
            // N을 생각해보자
            // N = 1 / N = 2 / N = 3 / N = 4 / N = 5 /
            // 아 그러면 나머지를 생각할 필요없이 while조건 되면 그냥 나가면 끝이네
            N++;
            currentNum++;
        }

        System.out.println(N);

/*
        // 등차 수열의 합을 활용하는 방법
        // 이분 탐색 (Binary Search)을 활용한 방법
        // 하나씩 빼서 가는것말고 업 다운 방식으로 해보는것
        // S가 200이라고 해볼게요. "정답(N)이 대충 1부터 200 사이에 있겠지?"
        // 중간값(100) 찌르기: "1부터 100까지 다 더하면 5050이네? 200보다 너무 커! (DOWN👇)" 👉 이제 100 이상은 쳐다볼 필요도 없습니다!
        // 남은 절반(50) 찌르기: "1부터 50까지 다 더하면 1275네? 이것도 커! (DOWN👇)"
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long left = 1;         // 정답이 될 수 있는 최소 N
        long right = S;        // 정답이 될 수 있는 최대 N (사실 루트 S까지만 해도 됨)
        long answer = 0;

        // 이분 탐색(Up & Down 게임) 시작!
        while (left <= right) {
            long mid = (left + right) / 2;           // 중간값 N 찌르기!
            long sum = (mid * (mid + 1)) / 2;        // 1부터 N까지의 합 공식

            if (sum <= S) {
                // 합이 S보다 작거나 같으면? "일단 정답 후보로 저장하고 더 큰 N이 가능한지 찾아보자!" (UP👆)
                answer = mid;
                left = mid + 1;
            } else {
                // 합이 S보다 크면? "N이 너무 크다! 줄여라!" (DOWN👇)
                right = mid - 1;
            }
        }

        System.out.println(answer);
*/
    }
}
