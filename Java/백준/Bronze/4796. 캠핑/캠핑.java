import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseNum = 1; // 케이스 번호를 추적하기 위한 변수
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            
            // L, P, V가 모두 0이면 입력의 끝이므로 종료
            if (L == 0 && P == 0 && V == 0) {
                break;
            }
            
            // 전체 휴가 중 연속하는 일수가 몇 번 온전히 들어가는지 계산하여 L을 곱함
            // 남은 휴가 일수와 캠핑 가능 일수 중 더 작은 값을 더함
            int totalDays = ((V / P) * L) + Math.min(V % P, L);
            
            // 출력 형식에 맞게 StringBuilder에 추가
            sb.append("Case ").append(caseNum).append(": ").append(totalDays).append("\n");
            caseNum++;
        }
        
        System.out.print(sb);
    }
}