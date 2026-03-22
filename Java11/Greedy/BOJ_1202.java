package Greedy;

import java.util.*;
import java.io.*;

class Jewelry implements Comparable<Jewelry> {
    int mass; // 무게
    int value; // 가격

    public Jewelry(int mass, int value) {
        this.mass = mass;
        this.value = value;
    }

    // Arrays.sort를 사용하기 위해서 쓰는 함수
    // 오름차순 정렬, 만약 내림차순으로 하고 싶다면 other과 this를 변경
    @Override
    public int compareTo(Jewelry other) {
        return this.mass - other.mass;
    }
}

public class BOJ_1202 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 보석 N개, 각 보석에는 무게 M과 가격 V가 존재
        // 가방 K개, 가방에 담을 수 있는 최대 무게 C
        // 가방에는 한개의 보석만 넣을 수 있음
        // 최대로 훔칠수있는 가격
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 앞으로 N개의 줄에 각 보석에 대한 무게와 가격이 존재
        Jewelry[] jewels = new Jewelry[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 앞으로 K개의 줄에 가방에 넣을수 있는 무게.
        int[] bags = new int[K];
        for(int i = 0; i < K;i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 보석과 가방 둘다 무게를 기준으로 오름차순으로
        Arrays.sort(jewels);

        Arrays.sort(bags);

        // 가장 비싼 가격이 먼저 나오는 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long totalValue = 0; // 가격의 총합은 엄청나게 커질 수 있으므로 long을 사용
        int jewelIndex = 0; // 현재 확인 중인 보석의 번호

        // 4. 제일 작은 가방부터 하나씩 챙겨봅시다.
        for (int i = 0; i < K; i++) {
            int currentBag = bags[i];

            // 현재 가방에 넣을 수 있는 무게의 보석들을 싹 다 큐에 넣습니다.
            // (보석 번호가 N을 넘지 않고, 보석 무게가 현재 가방 무게보다 작거나 같을 때까지)
            while (jewelIndex < N && jewels[jewelIndex].mass <= currentBag) {
                pq.offer(jewels[jewelIndex].value); // 가격만 상자에 넣습니다.
                jewelIndex++; // 다음 보석 확인
            }

            // 상자에 넣을 수 있는 보석이 있다면? 제일 비싼 걸 꺼내서 챙깁니다!
            if (!pq.isEmpty()) {
                totalValue += pq.poll();
            }

            // 이후 다시 for문으로 돌아가서
            // 이전에 가방에 넣었던 무게 이후의 보석부터 무게를 검사
            // 마찬가지로 집어 넣을 수 있는 최대 무게까지 큐에 집어넣고
            // 큐에 넣은 보석들 중에서 가장 비싼 녀석을 큐에서 추출
            // 이후 반복
            // 그렇다면 왜 큐를 쓰는가?
            // 시간 복잡도 떄문, 보석을 추출한 이유 보석의 배열 쪽도 수정을 해줘야하는데
            // 큐를 사용하면 해당 부분을 할 필요없음. 그냥 큐에서 뺴면 되기때문에.
        }

        System.out.println(totalValue);
    }
}
