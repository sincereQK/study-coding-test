import java.io.*;
import java.util.*;

public class Main {
    // 그래프 연결 상태를 저장할 2차원 배열 (인접 행렬)
    static boolean[][] graph;
    // 방문 여부를 체크할 배열
    static boolean[] visited;
    // 웜 바이러스에 걸린 컴퓨터 수
    static int count = 0;
    // 컴퓨터의 수
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        // 컴퓨터 번호가 1번부터 시작하므로 N + 1 크기로 생성
        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        
        // 네트워크 연결 정보 입력
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            // 양방향(무방향) 그래프이므로 양쪽 모두 true로 설정
            graph[u][v] = true;
            graph[v][u] = true;
        }
        
        // 1번 컴퓨터부터 탐색 시작
        dfs(1);
        
        // 1번 컴퓨터를 통해 감염된 컴퓨터의 수 출력
        System.out.println(count);
    }
    
    // 깊이 우선 탐색 (DFS) 메서드
    static void dfs(int node) {
        // 현재 노드 방문 처리
        visited[node] = true;
        
        // 1번부터 N번 컴퓨터까지 확인
        for (int i = 1; i <= N; i++) {
            // 현재 노드와 연결되어 있고, 아직 방문하지 않은 컴퓨터라면?
            if (graph[node][i] && !visited[i]) {
                count++;   // 감염된 컴퓨터 수 증가
                dfs(i);    // 해당 컴퓨터로 이동하여 다시 탐색 (재귀 호출)
            }
        }
    }
}