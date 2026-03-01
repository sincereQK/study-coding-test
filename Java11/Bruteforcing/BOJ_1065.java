package Bruteforcing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(hanSuCount(N));
    }

    public static int hanSuCount(int num) {
        int count = 0;


        if (num < 100) {
            return num;
        }
        else {
            count = 99;

            for (int i = 100; i <= num; i++) {
                if (i == 1000) {
                    break;
                }

                int hun = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;

                if ((hun - ten) == (ten - one)) {
                    count++;
                }
            }
        }

        return count;
    }
}
