package Bruteforcing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

// 좌표를 기억하기 위한 미니 클래스
class Point {
    int r, c;
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class BOJ_14502 {
    static int N, M;
    static int[][] map;
    static int maxSafeArea = 0; // 최대 안전 영역을 저장할 변수

    // 상, 하, 좌, 우 이동을 위한 마법의 배열
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        // 1. 연구소 지도 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 벽 세우기 시뮬레이션 시작! (현재 세운 벽의 개수 = 0)
        makeWall(0);

        // 3. 모든 경우의 수를 다 해본 뒤, 최대 안전 영역 출력
        System.out.println(maxSafeArea);
    }

    // ==========================================
    // 1단계: 백트래킹으로 벽 3개 세우기 (DFS)
    // ==========================================
    public static void makeWall(int wallCount) {
        // 벽 3개를 다 세웠다면? -> 바이러스 퍼뜨리기 시작
        if (wallCount == 3) {
            spreadVirus();
            return;
        }

        // 연구소 전체를 돌면서 빈칸(0)에 벽을 세움
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1; // 벽을 세운다 (카드 내기)
                    makeWall(wallCount + 1); // 다음 벽을 세우러 재귀 호출
                    map[i][j] = 0; // 탐색이 끝나면 다시 벽을 허문다 (카드 줍기)
                }
            }
        }
    }

    // ==========================================
    // 2단계 & 3단계: 바이러스 퍼뜨리기(BFS) 및 안전 영역 계산
    // ==========================================
    public static void spreadVirus() {
        // 1. 원본 지도를 보호하기 위해 복사본 만들기
        int[][] copyMap = new int[N][M];
        Queue<Point> queue = new LinkedList<>(); // 바이러스의 위치를 담을 큐(대기열)

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j]; // 지도 복사

                // 바이러스(2)를 발견하면 큐(대기열)에 넣습니다.
                if (copyMap[i][j] == 2) {
                    queue.add(new Point(i, j));
                }
            }
        }

        // 2. 큐가 빌 때까지(모든 바이러스가 퍼질 때까지) 반복 (BFS 핵심)
        while (!queue.isEmpty()) {
            Point current = queue.poll(); // 바이러스 하나를 꺼냅니다.

            // 상, 하, 좌, 우 4방향으로 퍼져나갑니다.
            for (int i = 0; i < 4; i++) {
                int nextR = current.r + dr[i];
                int nextC = current.c + dc[i];

                // 연구소 범위를 벗어나지 않고, 빈칸(0)이라면?
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) {
                    if (copyMap[nextR][nextC] == 0) {
                        copyMap[nextR][nextC] = 2; // 바이러스 감염
                        queue.add(new Point(nextR, nextC)); // 새롭게 감염된 곳도 큐에 넣어 퍼뜨리게 합니다.
                    }
                }
            }
        }

        // 3. 안전 영역(0) 개수 세기
        int safeCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    safeCount++;
                }
            }
        }

        // 4. 역대 최대 안전 영역 갱신
        maxSafeArea = Math.max(maxSafeArea, safeCount);
    }
}