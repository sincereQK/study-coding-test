import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // 알파벳 26개의 가중치를 저장할 배열
        int[] alpha = new int[26];
        
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            // 각 단어의 길이
            int len = word.length();
            // 맨 앞자리 알파벳의 자릿수 값
            int base = (int) Math.pow(10, len - 1);
            
            // 단어를 순회하며 각 알파벳의 가중치를 누적
            for (int j = 0; j < len; j++) {
                alpha[word.charAt(j) - 'A'] += base;
                base /= 10; // 다음 자리로 이동
            }
        }
        
        // 가중치 배열을 오름차순으로 정렬
        Arrays.sort(alpha);
        
        int sum = 0;
        int num = 9; // 가장 높은 가중치를 가진 알파벳부터 9를 곱해줌
        
        // 배열의 맨 뒤부터 역순으로 계산
        for (int i = 25; i >= 0; i--) {
            if (alpha[i] == 0) {
                break; // 가중치가 0은 등장하지 않은 알파벳 ->종료
            }
            sum += alpha[i] * num;
            num--;
        }
        
        System.out.println(sum);
    }
}