package Greedy;

import java.io.*;
import java.util.*;

public class BOJ_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 작은거 * 큰거 한다음에 더하면 될것같은데

        Arrays.sort(A);

        Arrays.sort(B);

        //Integer[] 일때만 쓸수있음, int[]은 안됨
        // Arrays.sort(B, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i] * B[N-1-i]; // N=5면, i=0,1,2,3,4 이므로 -1을 한번 더 해줘야함
        }

        System.out.println(sum);


    }
}
