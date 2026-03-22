package Greedy;

import java.io.*;
import java.util.*;

public class BOJ_2217 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] ropes = new int[N];

        for (int i = 0; i < N;i++){
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);
        // 오름차순 정렬을 했음

        // 로프가 2개 잖아.
        // 10 15
        // 그러면 10 하고 10을 하면 최대 중량이야

        // 로프가 3개 라고 해봐
        // 10 100 1000
        // 근데 이렇게 해도 결국 첫번쨰 줄은 10 이상의 무게를 들수가 없어. 그러므로 10 + 10 + 10이야

        // 아 근데 전부다 안쓸수도 있다고 했어.
        // 그러면 그냥 1000 하나만 들어도 가장 큰거가 된다.

        // 비교 하는 함수를써야해.

        // 가장 작은거 * N -> 그다음 작은거 * (N - 1) -> 그 다음 작은거 * (N -2) ...
        // 이렇게 해서 전부다 구해서 가장 큰 놈을 값으로 출력

        int maxWeight = 0;

        for(int i = 0; i < N; i++) {
            int currentMax = ropes[i] * (N - i);
            maxWeight = Math.max(maxWeight,currentMax);
        }

        System.out.println(maxWeight);

    }
}
