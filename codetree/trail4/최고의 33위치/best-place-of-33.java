import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i + 2 < N; i++) {
            for (int j = 0; j + 2 < N; j++) {
                int sum = 0;
                for (int di = 0; di < 3; di++)
                    for (int dj = 0; dj < 3; dj++)
                        sum += grid[i + di][j + dj];
                answer = Math.max(answer, sum);
            }
        }
        System.out.println(answer);
    }
}