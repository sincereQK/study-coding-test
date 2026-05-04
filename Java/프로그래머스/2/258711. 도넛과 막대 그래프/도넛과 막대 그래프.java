import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        Map<Integer, int[]> nodeDegree = new HashMap<>();
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            nodeDegree.putIfAbsent(from, new int[2]); // [out, in]
            nodeDegree.putIfAbsent(to, new int[2]);
            
            nodeDegree.get(from)[0]++; // out 증가
            nodeDegree.get(to)[1]++;   // in 증가
        }
        
        for (Integer key : nodeDegree.keySet()) {
            int[] degree = nodeDegree.get(key);
            int out = degree[0];
            int in = degree[1];
            
            // 생성된 정점 - 나가는 것 2개 이상, 들어오는 것 0개
            if (out >= 2 && in == 0) {
                answer[0] = key;
            }
            // 막대 그래프 - 나가는 것이 0개
            else if (out == 0 && in >= 1) {
                answer[2]++;
            }
            // 8자 그래프 - 나가는 것이 2개, 들어오는 것이 2개 이상
            else if (out == 2 && in >= 2) {
                answer[3]++;
            }
        }
        
        // 넛 그래프 - 생성된 정점의 전체 진출 차수 - 나머지 그래프들
        answer[1] = nodeDegree.get(answer[0])[0] - answer[2] - answer[3];
        
        return answer;
    }
}