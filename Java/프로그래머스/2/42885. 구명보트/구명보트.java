import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int minWeight = 0; //시작 최저 무게
        int maxWeight = people.length - 1; // 시작 최고 무게
        
        while(minWeight <= maxWeight) {
            // 최저 무게 + 최고 무게가 무게 제한보다 작으면
            if(people[minWeight]+people[maxWeight] <= limit) {
                //최저 무게도 태워서 같이 보냄
                minWeight++;
            }
            // 무게 합과는 관계없이 최고 무게는 항상 보내야함
            maxWeight--;
            answer++;
        }
        
        return answer;
    }
}