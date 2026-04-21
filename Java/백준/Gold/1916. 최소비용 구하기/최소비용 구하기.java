import java.io.*;
import java.util.*;

public class Main {
    
    // 도착 도시와 비용을 담을 Node
    static class Node implements Comparable<Node> {
        int to;
        int cost;
        
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        
        // 우선순위 큐에서 비용이 적은 것이 먼저 나오도록 오름차순 정렬
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 도시의 개수
        int M = Integer.parseInt(br.readLine()); // 버스의 개수
        
        ArrayList<Node>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph[from].add(new Node(to, cost));
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        // 최단 거리(최소 비용) 배열을 무한대로 초기화
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // 우선순위 큐 생성 및 시작 노드 삽입
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        
        // 큐가 빌 때까지 탐색
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            
            // 현재 큐에서 뽑은 비용이 이미 기록된 최소 비용보다 크다면 
            // 이미 처리된 노드이므로 무시
            if (curr.cost > dist[curr.to]) {
                continue;
            }
            
            // 현재 도시와 연결된 인접 도시들을 확인
            for (Node next : graph[curr.to]) {
                // 거쳐가는 비용이 다이렉트로 가는(또는 기존에 알려진) 비용보다 더 싸다면 갱신
                if (dist[next.to] > curr.cost + next.cost) {
                    dist[next.to] = curr.cost + next.cost;
                    // 갱신된 새로운 경로를 큐에 넣음
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
        
        System.out.println(dist[end]);
    }
}