import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        // 자바는 문자열이 S[i]처럼 꺼내서 쓸수가 없음
        // 처음에는 비트 연산으로 구할 수 있는지 고민을 했으나
        // S의 길이는 100만보다 작다. 는 조건이 있어서 비트로는 안되겠다 라고 생각했음
        // 그럼 문자열에서 0과 1의 갯수를 확인하는 방법을 고민해야함
        // 예제를 보니까 덩어리를 바꾸는것으로 카운트가 1이 바뀐다.
        // 그럼 0과 1이 바뀌는 지점의 갯수를 확인해야함
        // 그리고서 0이 많은지 1이 많은지를 확인해야하고
        // 그런 다음에 적은 쪽의 덩어리 갯수를 확인해야함

        int count0 = 0; // 0 덩어리 개수
        int count1 = 0; // 1 덩어리 개수

        //첫번째 덩어리가 무엇인지 확인 필요
        if (S.charAt(0) == '0') {
            count0++;
        } else {
            count1++;
        }

        // 일단 문자열 S의 전체를 확인
        // 위치 0과 위치 1을 비교해야하므로 1부터 시작
        for(int i = 1; i < S.length(); i++) {
            // 만약 현재 숫자와 이전 숫자가 다르다면
            // 덩어리가 구분되는 지점이다
            if(S.charAt(i - 1) != S.charAt(i)) {
                //현재 바뀌는 지점의 숫자를 확인해서 0의 덩어리인지 1의 덩어리 인지 확인 필요
                if(S.charAt(i) == '0'){
                    count0++;
                } else {
                    count1++;
                }

            }
        }

        // 두 덩어리중 작은 놈을 골라야함
        int minCount = Math.min(count0,count1);

        System.out.println(minCount);

    }
}
