package bronze;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 풀이 코드
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));

    }
}


/*
이 문제의 핵심은 n이 최대 10^1000이라는 거야. double이나 long으로는 이 숫자를 담을 수 없어.
자바에서는 이런 엄청 큰 수를 다룰 때 **BigInteger**를 써야 해.
파이썬은 큰 수를 자동으로 처리해줘서 신경 안 써도 됐지만, 자바는 별도 클래스가 필요해.
*/