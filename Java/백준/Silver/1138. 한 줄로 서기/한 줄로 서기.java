import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 사람의 수 N 입력
        int n = Integer.parseInt(br.readLine());
        
        // 줄을 설 위치를 저장할 배열
        int[] line = new int[n];
        
        // 둘째 줄 입력: 각 사람(키 1~N)의 왼쪽에 자신보다 키가 큰 사람이 몇 명 있는지
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 키가 1인 사람부터 N인 사람까지 순서대로 자리를 찾아 배치
        for (int i = 1; i <= n; i++) {
            // 내 왼쪽에 있어야 할 키 큰 사람의 수
            int leftCount = Integer.parseInt(st.nextToken()); 
            
            int emptyCount = 0; // 지나친 빈자리의 수
            
            // 배열을 앞에서부터 탐색하며 들어갈 자리를 찾음
            for (int j = 0; j < n; j++) {
                // 아직 아무도 서지 않은 빈자리일 경우에만 카운트
                if (line[j] == 0) {
                    // 왼쪽에 키 큰 사람을 위한 빈자리를 모두 확보했다면 현재 자리에 선다
                    if (emptyCount == leftCount) {
                        line[j] = i; 
                        break; // 자리를 찾았으므로 다음 사람으로 넘어감
                    }
                    emptyCount++; // 아직 자리를 덜 확보했다면 빈자리 카운트 증가
                }
            }
        }
        
        // 최종 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(line[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}