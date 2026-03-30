import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            int n = Integer.parseInt(br.readLine());
            
            // 0이 입력되면 종료
            if (n == 0) {
                break;
            }
            
            // 1부터 n까지의 합
            long totalBlocks = (long) n * (n + 1) / 2;
            sb.append(totalBlocks).append("\n");
        }
        
        System.out.print(sb);
    }
}