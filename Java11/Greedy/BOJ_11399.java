package Greedy;

import java.io.*;
import java.util.*;

public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }


        //5
        //3 1 4 3 2
        //최소로 정렬을 한다음에 더하면 되는거 아닌가?

        Arrays.sort(P);

        int prevTime = 0;
        int totalTime = 0;

        for (int i = 0; i < N; i++) {
            // 대시 시간 + 내 시간 = 내가 돈을 다 뽑은 후 까지 걸린시간
            prevTime = prevTime + P[i];

            // 총 시간에다가 현재사람의 모든 시간을 더하기
            totalTime = totalTime +  prevTime;

        }

        System.out.println(totalTime);


    }
}
