import java.util.*;

class Solution {
    
    int[] parent;
    
    // 루트 노드 찾기
    // 어떤 집합, 어떤 루트 노드에 속해있는 확인하는 함수
    public int find(int child) {
        if(parent[child] == child) return child;
        return parent[child] = find(parent[child]);
    }
    
    // 서로 다른 2개의 집합을 하나로 합치는것
    // 두 집합의 루트 노드를 통합 시킴
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB) {
            parent[rootB] = rootA;
        }     
    }
    
    // 섬0과 섬1 사이에 다리를 짓기로 함
    // 그러면 0과 1은 한팀이 됨.
    // 이러면 섬0이 루트 노드, 보통 작은 숫자를 루트 노드로 지정
    // 섬2 와 섬0을 이으려고 함, 이떄 섬2는 루트노드가 2, 섬0은 루트노드가 0 
    // 서로의 루트 노드가 다르므로 다리를 짓고 섬2의 루트노드를 0으로 변경
    
    // 추가적으로 0-1이 연결되어있고 1-2가 연결되어있으면
    // 0과 2는 서로 연결되어있지는 않지만 1로 거쳐서 지나갈수있음
    // find 함수를 통해서 find(2) -> find(1) -> 0
    // 이를 통해서 루트 노드가 같으므로 서로 연결되어있다고 확인할수있음
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        // 최소 건설 비용이 답
        // 일단 비용 기준으로 오름차순 정렬이 필요
        Arrays.sort(costs, (a,b) -> Integer.compare(a[2],b[2]));
        
        // 정렬된 비용 리스트에서 순서대로 하나씩 꺼내서
        // 두 섬 중에서 섬을 지칭하는 숫자가 작은 섬을 확인하여 루트 노드 확인, 대장 지정
        // 그래서 다리 2개를 비교했을때, 루트 노드가 같으면 이미 연결되어있는거고,
        // 루트 노드가 다르면 이미 연결되어있지 않다.
        // 유니온-파인드를 사용해서, 집합구분밑 합치기 진행
        
        for(int[] edge : costs) {
            int start = edge[0];
            int end = edge[1];
            int cost = edge[2];
            
            if(find(start) != find(end)) {
                union(start,end);
                answer += cost;
            }
            
        }
        
        return answer;
    }
}