import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();
        
        // "XXXX"를 모두 "AAAA"로 바꿉니다.
        board = board.replaceAll("XXXX", "AAAA");
        
        // 남은 "XX"를 모두 "BB"로 바꿉니다.
        board = board.replaceAll("XX", "BB");
        
        // 치환이 끝났는데도 'X'가 남아있다면 폴리오미노로 덮을 수 없는 보드임
        if (board.contains("X")) {
            System.out.println("-1");
        } else {
            // 결과 출력
            System.out.println(board);
        }
    }
}