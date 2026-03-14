package Bruteforcing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_14889 {

    static int N;
    static int[][] S; // 능력치 표를 저장할 2차원 배열
    static boolean[] visited; // 스타트 팀에 뽑혔는지 확인하는 출석부
    static int minDiff = Integer.MAX_VALUE; // 능력치 차이의 최솟값을 저장할 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];

        // 1. 능력치 표(S) 데이터 입력받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 0번 사람부터 차례대로 팀 뽑기 시작! (현재 뽑은 인원수: 0명)
        dfs(0, 0);

        // 3. 모든 경우의 수를 다 찾아보고 난 후, 가장 작았던 점수 차이 출력
        System.out.println(minDiff);
    }

    // ==========================================
    // 1단계: 백트래킹으로 N/2명 뽑기 (조합)
    // ==========================================
    // index: 이번에 몇 번 사람부터 뽑을 차례인지?
    // count: 지금까지 스타트 팀에 몇 명을 뽑았는지?
    public static void dfs(int index, int count) {

        // 1. 종료 조건: 스타트 팀에 N/2명이 다 모였다면?
        if (count == N / 2) {
            // 점수 차이를 계산하는 별도의 함수를 호출합니다!
            calculateDiff();
            return; // 계산이 끝났으니 이전으로 돌아가서 다른 멤버 조합을 찾습니다.
        }

        // 2. index 번호의 사람부터 마지막 사람까지 한 명씩 스타트 팀에 넣어봅니다.
        for (int i = index; i < N; i++) {
            // 아직 팀이 없는 사람이라면?
            if (!visited[i]) {
                visited[i] = true; // "너 스타트 팀 해라!" (카드 내기)

                // 다음 사람을 뽑으러 재귀 호출! (사람 수는 1 늘어나고, 다음 탐색은 i + 1번 사람부터)
                dfs(i + 1, count + 1);

                visited[i] = false; // "아까 그건 취소, 다른 사람 뽑아보자" (카드 줍기)
            }
        }
    }

    // ==========================================
    // 2단계: 두 팀의 능력치 차이 계산하기
    // ==========================================
    public static void calculateDiff() {
        int startTeamScore = 0;
        int linkTeamScore = 0;

        // 전체 사람들을 1:1로 짝지어서 봅니다. (이중 for문)
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {

                // 만약 i번째 사람과 j번째 사람이 둘 다 스타트 팀(true)이라면?
                if (visited[i] && visited[j]) {
                    startTeamScore += S[i][j] + S[j][i];
                }
                // 만약 둘 다 링크 팀(false)이라면?
                else if (!visited[i] && !visited[j]) {
                    linkTeamScore += S[i][j] + S[j][i];
                }
            }
        }

        // 3. 두 팀의 점수 차이의 '절댓값'을 구합니다. (음수가 나오면 안 되니까요!)
        int val = Math.abs(startTeamScore - linkTeamScore);

        // [초강력 꿀팁 최적화 ⭐] 점수 차이가 0이라면 이보다 더 작을 수는 없습니다!
        if (val == 0) {
            System.out.println(val);
            System.exit(0); // 더 이상 뒤져볼 필요 없이 프로그램을 그 자리에서 바로 끝내버립니다.
        }

        // 4. 역대 최소 차이(minDiff)와 비교해서 더 작다면 갱신!
        minDiff = Math.min(minDiff, val);
    }
}