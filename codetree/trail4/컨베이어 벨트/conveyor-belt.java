import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int L = 2 * N;
        int[] belt = new int[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) belt[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) belt[N + i] = Integer.parseInt(st.nextToken());

        int shift = T % L;
        int[] rot = new int[L];
        for (int i = 0; i < L; i++) rot[(i + shift) % L] = belt[i];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(rot[i]);
            if (i < N - 1) sb.append(' ');
        }
        sb.append('\n');
        for (int i = 0; i < N; i++) {
            sb.append(rot[N + i]);
            if (i < N - 1) sb.append(' ');
        }
        System.out.println(sb);
    }
}