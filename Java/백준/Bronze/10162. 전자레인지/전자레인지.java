import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] microwave = {300,60,10};

        int[] count = {0,0,0};

        if (T % 10 != 0) {
            System.out.println(-1);
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (T >= microwave[i]) {
                count[i] = T / microwave[i];
                T = T % microwave[i];
            }
        }

        for (int num : count) {
            System.out.print(num + " ");
        }
    }
}
