import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        printNSquare(N);
    }

    public static void printNSquare(int n) {
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (num % 9 == 0) {
                    System.out.print(num+" ");
                    num = 1;
                } else {
                    System.out.print(num+" ");
                    num++;
                }
            }
            System.out.println();
        }
    }

}