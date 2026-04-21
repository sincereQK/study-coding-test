import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1, 0);
        
        System.out.print(sb);
    }

    // at 현재 탐색을 시작할 위치
    // depth 현재까지 고른 숫자의 개수
    static void dfs(int at, int depth) {
        // M개의 숫자를 모두 골랐다면 출력 버퍼에 담는다
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        // at부터 N까지 순회하며 비내림차순 수열을 만든다
        for (int i = at; i <= N; i++) {
            arr[depth] = i; // 현재 깊이에 숫자 저장
            
            // 중복 선택을 허용하므로 다음 탐색도 i부터 시작하도록 넘겨줌
            dfs(i, depth + 1);
        }
    }
}