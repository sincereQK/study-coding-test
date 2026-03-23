package Greedy;

import java.io.*;
import java.util.*;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        String input = br.readLine();

        // 적절히 괄호를 쳐서 최소값을 만들어야함
        // 그러니까 +를 먼저 다 합한 다음에
        // 남아있는것들 전부 뺴면 보통 최소값이겠지?
        // 그러면 일단 +들 연살들은 다 한다음에 마지막에 -를 해야함
        // 일단 문자열로 왔으니 숫자들만 따로 건져야함

        // 예시
        // 55-50+40
        // minusSplit 후 = [55, 50+40]
        // minusSplit 후 = [55, [50,40]]
        // 이러면 50,40을 합침
        // [55, 90]
        // 남은거 다뺌
        // 다 뺴는거나 다 더하는거는 어떻게 해야하지?
        // 그리고 괄호가 필요벗는거는?

        int total = 0;

        String[] minusSplit = input.split("-");

        for (int i=0; i<minusSplit.length; i++) {
            int temp = 0;
            String[] plusSplit = minusSplit[i].split("\\+");

            // + 인 친구들 다 더해줘야함
            for (int j = 0; j < plusSplit.length; j++) {
                temp += Integer.parseInt(plusSplit[j]);
            }

            if (i == 0) {
                total += temp; // 맨 처음 숫자는 무조건 양수니까 더해줍니다! (예: 55)
            } else {
                total -= temp; // 그 뒤에 나오는 덩어리들은 몽땅 빼버립니다! (예: 90)
            }

        }

        System.out.println(total);
    }
}
