import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        
        // Collections.sort()는 Timsort를 사용하여 최악의 경우에도 O(N log N) 보장
        Collections.sort(list);
        
        for (int val : list) {
            sb.append(val).append("\n");
        }
        
        System.out.print(sb);
    }
}