import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());

            sb.append(C / 25).append(" ");
            C %= 25;

            sb.append(C / 10).append(" ");
            C %= 10;

            sb.append(C / 5).append(" ");
            C %= 5;

            sb.append(C).append("\n");
        }
        System.out.print(sb.toString());
    }
}