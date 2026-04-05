import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int swapCount = 0;

        // 버블 정렬 로직 구현
        for (int last = N - 1; last > 0; last--) {
            for (int i = 0; i < last; i++) {
                // 앞의 원소가 더 크면 교환 (오름차순 정렬)
                if (A[i] > A[i + 1]) {
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                    
                    swapCount++; // 교환 발생 시 카운트 증가

                    // K번째 교환인 경우 정답 출력 후 조기 종료
                    if (swapCount == K) {
                        // 교환 직후이므로 A[i]가 더 작은 값, A[i+1]이 더 큰 값
                        System.out.println(A[i] + " " + A[i + 1]);
                        return;
                    }
                }
            }
        }

        // 정렬이 모두 끝났는데도 K에 도달하지 못한 경우
        System.out.println(-1);
    }
}