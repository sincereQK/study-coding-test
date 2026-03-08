package Bruteforcing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class BOJ_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dwarfs = new int[9];
        int totalSum = 0;

        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
            totalSum += dwarfs[i];
        }

        Arrays.sort(dwarfs);

        int target = totalSum - 100;

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {

                if (dwarfs[i] + dwarfs[j] == target) {

                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        System.out.println(dwarfs[k]);
                    }
                    
                    return;
                }
            }
        }
    }
}
