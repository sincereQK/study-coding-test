import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] g = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                g[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][][] shapes = {
            {{0,0},{0,1},{1,0}},
            {{0,0},{0,1},{1,1}},
            {{0,0},{1,0},{1,1}},
            {{0,1},{1,0},{1,1}},
            {{0,0},{0,1},{0,2}},
            {{0,0},{1,0},{2,0}}
        };

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int[][] shape : shapes) {
                    int sum = 0;
                    boolean valid = true;
                    for (int[] d : shape) {
                        int nr = i + d[0], nc = j + d[1];
                        if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                            valid = false;
                            break;
                        }
                        sum += g[nr][nc];
                    }
                    if (valid) answer = Math.max(answer, sum);
                }
            }
        }
        System.out.println(answer);
    }
}