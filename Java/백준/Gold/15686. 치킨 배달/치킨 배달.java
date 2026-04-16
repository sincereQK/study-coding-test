import java.io.*;
import java.util.*;

public class Main {
    
    // 좌표를 저장할 클래스
    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static int N, M;
    static ArrayList<Point> houses = new ArrayList<>();
    static ArrayList<Point> chickens = new ArrayList<>();
    static boolean[] selected; // 치킨집 선택 여부를 저장할 배열
    static int minCityDistance = Integer.MAX_VALUE; // 최소 도시 치킨 거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    houses.add(new Point(i, j));
                } else if (val == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }
        
        // 치킨집의 총 개수만큼 방문 배열
        selected = new boolean[chickens.size()];
        
        // 백트래킹을 이용한 조합 찾기
        backtrack(0, 0);
        
        System.out.println(minCityDistance);
    }
    
    // 치킨집 중 M개를 선택하는 백트래킹
    static void backtrack(int start, int count) {
        // M개의 치킨집을 모두 골랐다면, 거리를 계산
        if (count == M) {
            calculateCityDistance();
            return;
        }
        
        // start 인덱스부터 탐색하여 중복 없는 조합을 생성
        for (int i = start; i < chickens.size(); i++) {
            selected[i] = true;
            backtrack(i + 1, count + 1); // 다음 치킨집으로 가기
            selected[i] = false; // 원상 복구
        }
    }
    
    // 선택된 M개의 치킨집을 기준으로 도시의 치킨 거리를 계산
    static void calculateCityDistance() {
        int totalDistance = 0;
        
        for (Point h : houses) {
            int minHouseDist = Integer.MAX_VALUE;
            
            for (int i = 0; i < chickens.size(); i++) {
                if (selected[i]) {
                    Point c = chickens.get(i);
                    // 맨해튼 거리 계산: |r1 - r2| + |c1 - c2|
                    int dist = Math.abs(h.r - c.r) + Math.abs(h.c - c.c);
                    minHouseDist = Math.min(minHouseDist, dist);
                }
            }
            totalDistance += minHouseDist;
        }
        
        minCityDistance = Math.min(minCityDistance, totalDistance);
    }
}