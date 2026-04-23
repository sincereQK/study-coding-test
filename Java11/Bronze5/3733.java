import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // EOF 처리: 스트림에 다음에 읽을 정수가 존재하는 동안만 반복
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int S = sc.nextInt();
            
            // N명의 사람 + 1명의 심판장에게 공평하게 분배
            System.out.println(S / (N + 1));
        }
        
        sc.close();
    }
}
