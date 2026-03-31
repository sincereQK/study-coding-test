import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    
    static int M, N, K;
    static int[][] cabbage;
    static boolean[][] visited;
    // 상하좌우 이동을 위한 방향 벡터
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 길이 (X)
            N = Integer.parseInt(st.nextToken()); // 세로 길이 (Y)
            K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수

            cabbage = new int[N][M];
            visited = new boolean[N][M];

            // 배추 위치 입력
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbage[y][x] = 1; // 2차원 배열은 [행][열]이므로 [y][x]로 접근
            }

            int wormCount = 0;

            // 배추밭 전체 순회
            for (int i = 0; i < N; i++) { // i는 행(y)
                for (int j = 0; j < M; j++) { // j는 열(x)
                    // 배추가 있고 아직 방문하지 않은 곳이라면 BFS 탐색 시작
                    if (cabbage[i][j] == 1 && !visited[i][j]) {
                        bfs(j, i); 
                        wormCount++; // 구역 하나 탐색 완료 시 지렁이 1마리 추가
                    }
                }
            }
            
            // 각 테스트 케이스마다 결과 출력
            System.out.println(wormCount);
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[y][x] = true; // 시작점 방문 처리

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            // 현재 위치에서 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 배추밭 범위를 벗어나지 않는지 확인
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    // 배추가 심어져 있고, 아직 방문하지 않았다면
                    if (cabbage[ny][nx] == 1 && !visited[ny][nx]) {
                        q.add(new int[]{nx, ny});
                        visited[ny][nx] = true; // 큐에 넣을 때 방문 처리
                    }
                }
            }
        }
    }
}