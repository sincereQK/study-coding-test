import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int result = findMin(A,B,C);

        System.out.print(result);

    }

    public static int findMin(int a, int b, int c) {
        int min = Integer.MAX_VALUE;

        if (a < min) {
            min = a;
        }

        if (b < min) {
            min = b;
        }

        if (c < min) {
            min = c;
        }

        return min;
    }

}