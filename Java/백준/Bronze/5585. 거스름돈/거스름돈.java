import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int price = Integer.parseInt(br.readLine());
        int left = 1000 - price;

        int[] yen = {500,100,50,10,5,1};

        int count = 0;
        
        for (int i = 0; i < yen.length; i++) {
            if(left >= yen[i]) {
                    count += left / yen[i];
                    left = left % yen[i];
            }
        }
        
        System.out.println(count);
    }
}
